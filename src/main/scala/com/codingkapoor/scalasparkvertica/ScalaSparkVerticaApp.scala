package com.codingkapoor.scalasparkvertica

import org.apache.spark.sql.{DataFrame, SparkSession}

object ScalaSparkVerticaApp extends App with SparkService with Vertica {
  val sparkSession: SparkSession =
    SparkSession.builder()
      .appName(Config.appName)
      .master(Config.sparkMaster)
      .getOrCreate()

  using(sparkSession) { implicit sparkSession =>
    println(count(readDataFromSource))
  }
}
