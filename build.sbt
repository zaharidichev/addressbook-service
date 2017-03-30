scalaVersion := "2.11.8"
organization := "com.zahari"
name := "addressbook-service"
version := "1.0"
scalacOptions ++= Seq("-Xfatal-warnings", "-feature", "-deprecation")
outputStrategy := Some(StdoutOutput)

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-http_2.11" % "10.0.5",
  "com.typesafe.akka" % "akka-http-spray-json-experimental_2.11" % "2.4.11.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.5" % "test",
  "com.github.nscala-time" %% "nscala-time" % "2.16.0",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5"
)
