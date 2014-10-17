package evecalc.dbimporter.util

import scala.slick.driver.H2Driver.simple._
import slick.Tables
import models.Item

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
      TableQuery[Tables.Items].insert(Tables.ItemsRow(item.typeID, Some(item.typeName)))
    }
  }
}
