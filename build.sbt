name := "scala-spark-vertica"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  ("org.apache.spark" %% "spark-core" % "2.4.3"),
  ("org.apache.spark" %% "spark-sql" % "2.4.3")
)

unmanagedJars in Compile ++= Seq(
  baseDirectory.value / "lib/vertica-spark2.1_scala2.11.jar",
  baseDirectory.value / "lib/vertica-jdbc-10.0.0-0.jar"
)
