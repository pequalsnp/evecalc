package evecalc.importer

import com.typesafe.slick.driver.ms.SQLServerDriver.simple._
import scala.slick.jdbc.meta.MTable

object EveSDEImporter {
  def main(args: Array[String]): Unit = {
    Class.forName("net.sourceforge.jtds.jdbc.Driver")
    Database.forURL(
      url = "jdbc:jtds:sqlserver://localhost/eveonline_crius",
      driver = "com.typesafe.slick.driver.ms.SQLServerDriver",
      user = "eve",
      password = "database"
    ) withSession { implicit session =>
      println(MTable.getTables(None, None, None, Some(Seq("TABLE"))).list)
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