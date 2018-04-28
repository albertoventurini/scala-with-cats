import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.albertoventurini",
      scalaVersion := "2.12.5",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "AdvancedScalaWithCats",
    libraryDependencies += "junit" % "junit" % "4.11" % "test",
    libraryDependencies += scalaTest % Test
  )
