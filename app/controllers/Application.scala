package controllers

import play.api._
import play.api.mvc._
import scala.slick.driver.H2Driver.simple._
import slick.Tables
import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def items = Action {
    Class.forName("org.h2.Driver")
    Database.forURL(
      url = "jdbc:h2:./data/evecalcStatic",
      driver = "org.h2.Driver"
    ) withSession { implicit session =>
      val items = Tables.Items.list.map { row =>
        new Item {
          override val typeID: TypeID = row.id

          override val typeName: String = row.name.getOrElse("")

          override val category: ItemCategory = ItemCategory(0, "")

          override val marketGroupID: Option[Int] = None
        }
      }
      Ok(views.html.items(items))
    }
  }

}