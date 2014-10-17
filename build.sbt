name := """evecalc"""

version := "1.0-SNAPSHOT"

lazy val evecalc = (project in file(".")).enablePlugins(PlayScala)

// db schema code generation task
lazy val slick = TaskKey[Seq[File]]("gen-tables")
lazy val slickCodeGenTask = (baseDirectory, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
  val outputDir = (dir / "app").getPath
  val url = "jdbc:h2:mem:test;INIT=runscript from 'data/init.sql'"
  val jdbcDriver = "org.h2.Driver"
  val slickDriver = "scala.slick.driver.H2Driver"
  val pkg = "slick"
  toError(r.run("scala.slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg), s.log))
  val fname = outputDir + "/slick/Tables.scala"
  Seq(file(fname))
}

scalaVersion in ThisBuild := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.h2database" % "h2" % "1.4.181",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.typesafe.slick" %% "slick-codegen" % "2.1.0"
)

slick <<= slickCodeGenTask

sourceGenerators in Compile <+= slickCodeGenTask

lazy val dbImporter = (project in file("dbImporter")).dependsOn(evecalc)
