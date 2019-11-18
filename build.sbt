name := "myscala-app"
organization := "com.amdelamar"
version := "1.0"
scalaVersion := "2.12.10"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.1.10",
  "com.typesafe.akka" %% "akka-stream" % "2.5.25",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.1.10" % Test,
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.25" % Test,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

lazy val root = (project in file("."))
enablePlugins(JavaAppPackaging)

// heroku deployment configs
herokuAppName in Compile := "myscala-app"
herokuJdkVersion in Compile := "1.8"
herokuConfigVars in Compile := Map(
  "HOST" -> "0.0.0.0"
)
herokuProcessTypes in Compile := Map(
  "web" -> "target/universal/stage/bin/myscala-app"
)
