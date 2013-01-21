import sbt._
import Keys._

object build extends Build{
  val buildSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion := "2.10.0"
  )

  lazy val root = Project(
    "main",
    file("."),
    settings = buildSettings
  )dependsOn(macrodef)

  lazy val macrodef = Project(
    "macrodef",
    file("macrodef"),
    settings = buildSettings ++ Seq(
      libraryDependencies <++= scalaVersion{ v =>
        Seq(
          "org.scala-lang" % "scala-reflect" % v
        )
      }
    )
  )
}