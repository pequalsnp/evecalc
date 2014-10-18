name := """evecalc"""

version := "1.0.0-SNAPSHOT"

lazy val evecalcMain = (project in file(".")).enablePlugins(PlayScala).dependsOn(evecalcCommon)

scalaVersion in ThisBuild := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.h2database" % "h2" % "1.4.181",
  "com.typesafe.slick" %% "slick" % "2.1.0"
)

lazy val evecalcCommon = (project in file("common"))

lazy val dbImporter = (project in file("dbImporter")).dependsOn(evecalcCommon)
