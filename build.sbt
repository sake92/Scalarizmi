
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

organization := "ba.sake"
name := "scalarizmi"
description := "Algorithms and data structures, in Scala"

version := "0.0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "ba.sake" % "hepek-classycle" % "0.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(DoubleIndentConstructorArguments, true)
  .setPreference(DanglingCloseParenthesis, Force)
  .setPreference(NewlineAtEndOfFile, true)

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

scmInfo := Some(ScmInfo(url("https://github.com/sake92/Scalarizmi"), "scm:git:git@github.com:sake92/Scalarizmi.git"))

developers += Developer("sake92", "Sakib Hadžiavdić", "sakib@sake.ba", url("http://sake.ba"))

homepage := Some(url("http://sake.ba"))
