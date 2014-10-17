name := "evecalc-dbimporter"

version := "1.0.0-SNAPSHOT"

resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/"

libraryDependencies ++= Seq(
  "com.h2database" % "h2" % "1.4.181",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.typesafe.slick" %% "slick-extensions" % "2.1.0",
  "com.typesafe.slick" %% "slick-codegen" % "2.1.0",
  "net.sourceforge.jtds" % "jtds" % "1.2",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.yaml" % "snakeyaml" % "1.11"
)