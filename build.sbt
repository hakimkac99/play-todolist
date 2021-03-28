name := """todolistProject"""
organization := "com.kacemi"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.13.3"

libraryDependencies += guice

libraryDependencies += jdbc

libraryDependencies += "com.h2database" % "h2" % "1.4.199"

libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"

libraryDependencies += "com.google.code.gson" % "gson" % "1.7.1"

PlayKeys.devSettings := Seq("play.server.http.port" -> "8080")

