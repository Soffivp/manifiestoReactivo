ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.4"
ThisBuild / libraryDependencies += "com.lihaoyi" %% "scalarx" % "0.4.3"
lazy val root = (project in file("."))
  .settings(
    name := "manifestReactive"
  )
