ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"
val akkaHttpVersion = "10.1.11"
val akkaVersion = "2.5.26"
lazy val root = (project in file("."))
  .settings(
    name := "scalaAkka",
    libraryDependencies ++= Seq(
      "net.liftweb" %% "lift-json" % "3.4.2",
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,

    )
  )



