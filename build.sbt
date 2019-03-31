
import Dependencies._

lazy val commonSettings = Seq(
  name         := "scala-playground",
  version      := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.8"
)

scalacOptions := Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Ypartial-unification",
  "-Ywarn-unused-import"
)

lazy val `scala-playground-object` = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    commonSettings,
    Defaults.itSettings,
    dependencyOverrides ++= coreDependencies,
    libraryDependencies ++= platformDependencies ++ testDependencies
  )
