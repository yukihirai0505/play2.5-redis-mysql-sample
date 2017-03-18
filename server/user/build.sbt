name := """user"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= {
  Seq(
    jdbc
    , cache
    , ws

    // DATABASE
    , "com.typesafe.play" %% "play-slick" % "2.0.2"
    , "mysql" % "mysql-connector-java" % "6.0.5"

    // DATABASE OPTION
    , "com.github.takezoe" %% "blocking-slick" % "0.0.2"
    , "com.github.tototoshi" %% "slick-joda-mapper" % "2.2.0"

    // CACHE
    , "net.debasishg" %% "redisreact" % "0.8"

    // TEST
    , "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
  )
}