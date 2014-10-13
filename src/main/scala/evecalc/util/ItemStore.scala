package evecalc.util

import com.typesafe.slick.driver.ms.SQLServerDriver.simple._
import evecalc.common.items._
import evecalc.data.Tables

import scala.collection.mutable

object ItemStore {
  val loadedItems: mutable.Map[TypeID, Item] = mutable.Map.empty

  def get(typeID: TypeID): Option[Item] = {
    loadedItems.get(typeID) orElse {
      val newItem = EveDB.getBasicItem(typeID)
      newItem foreach { item =>
        loadedItems += ((typeID, item))
      }
      newItem
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

