package evecalc.util

import com.typesafe.slick.driver.ms.SQLServerDriver.simple._
import evecalc.common.items._
import evecalc.data.Tables

object EveDB {
  val db = {
    Class.forName("net.sourceforge.jtds.jdbc.Driver")
    Database.forURL(
      url = "jdbc:jtds:sqlserver://localhost/eveonline_oceanus",
      driver = "com.typesafe.slick.driver.ms.SQLServerDriver",
      user = "eve",
      password = "database"
    )
  }

  def getTypeName(typeID: TypeID): Option[String] = {
    val result = EveDB.db.withSession { implicit session =>
      Tables.Invtypes.filter(_.typeid === typeID.toInt).map(_.typename).run
    }
    result.headOption.map(_.getOrElse(""))
  }

  def getBasicItem(typeID: TypeID): Option[Item] = {
    val query =
      for {
        item <- Tables.Invtypes if item.typeid === typeID
        group <- Tables.Invgroups if group.groupid === item.groupid
        category <- Tables.Invcategories if category.categoryid === group.categoryid
      } yield {
        (item, group, category)
      }
    val result = EveDB.db.withSession { implicit session =>
      query.run
    }
    result.headOption flatMap { itemInfo =>
      val (item, itemGroup, itemCategory) = itemInfo
      for {
        categoryID <- itemGroup.categoryid
      } yield {
        new Item {
          override val typeID: TypeID = item.typeid

          override val typeName: String = item.typename.getOrElse("")

          override val category: ItemCategory =
            ItemCategory(itemCategory.categoryid, itemCategory.categoryname.getOrElse(""))

          override val marketGroupID: Option[Int] = item.marketgroupid
        }
      }
    }
  }
}

/*
   Copyright 2014 Kyle Galloway (kyle.s.galloway@gmail.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
