package controllers

import play.api._
import play.api.mvc._
import scala.slick.driver.H2Driver.simple._
import slick.Tables
import models._
import util.EvecalcDB

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def items = Action {
    val items = EvecalcDB.
    Ok(views.html.items(items))
  }

}