name := "evecalc"

version := "1.0.0-SNAPSHOT"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.typesafe.slick" %% "slick-extensions" % "2.1.0",
  "com.typesafe.slick" %% "slick-codegen" % "2.1.0",
  "net.sourceforge.jtds" % "jtds" % "1.2",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.yaml" % "snakeyaml" % "1.14",
  "com.twitter" %% "finagle-http" % "6.22.0"
)
