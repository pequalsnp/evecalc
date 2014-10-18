name := """evecalc-common"""

version := "1.0.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.1"

libraryDependencies ++= Seq(
  "com.h2database" % "h2" % "1.4.181",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.typesafe.slick" %% "slick-codegen" % "2.1.0"
)

lazy val slickCommonCodeGenTask = (sourceDirectory, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
  val outputDir = (dir / "main/scala").getPath
  val url = "jdbc:h2:mem:test;INIT=runscript from 'data/init.sql'"
  val jdbcDriver = "org.h2.Driver"
  val slickDriver = "scala.slick.driver.H2Driver"
  val pkg = "slick"
  toError(r.run("scala.slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg), s.log))
  val fname = outputDir + "/slick/Tables.scala"
  Seq(file(fname))
}

sourceGenerators in Compile <+= slickCommonCodeGenTask
