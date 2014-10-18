package util

import models._
import slick.Tables
import scala.slick.driver.H2Driver.simple._

object EvecalcDB {
  val db = {
    Class.forName("org.h2.Driver")
    Database.forURL(
      url = "jdbc:h2:./data/evecalcStatic;INIT=runscript from './data/init.sql'",
      driver = "org.h2.Driver"
    )
  }

  def writeItem(item: Item): Unit = {
    db.withSession { implicit session =>
      Tables.Items.insert(
        Tables.ItemsRow(
          item.typeID,
          Some(item.typeName),
          Some(item.category.categoryID),
          Some(item.category.name),
          Some(item.marketGroupID)
        )
      )
    }
  }

  def items: Seq[Item] = {
    db.withSession { implicit session =>
      Tables.Items.list map { row =>
        new Item {
          override val typeID: Int = row.id
          override val typeName: Option[String] = row.name
          override val category: ItemCategory = ItemCategory(row.categoryID, row.categoryName)
          override val marketGroupID: Int = row.marketGroupID
        }
      }
    }
  }
}
