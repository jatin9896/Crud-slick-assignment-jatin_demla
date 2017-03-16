name := """slick-practice"""

version := "1.0"

scalaVersion := "2.12.1"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"




//scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
//libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.0",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0",
  "org.postgresql" % "postgresql" % "9.4.1212",
  "com.h2database" % "h2" % "1.4.193"
)
// https://mvnrepository.com/artifact/mysql/mysql-connector-java
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.40"
