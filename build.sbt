ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "SparkTest"
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.5.1",
  "org.apache.spark" %% "spark-sql" % "3.5.1"
)

libraryDependencies += "log4j" % "log4j" % "1.2.17"


libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

fork := true