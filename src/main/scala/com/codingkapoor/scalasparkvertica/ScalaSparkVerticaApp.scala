package com.codingkapoor.scalasparkvertica

import org.apache.spark.sql.SparkSession

object ScalaSparkVerticaApp extends SparkService with Vertica {
  def main(args: Array[String]): Unit = {
    val sparkSession: SparkSession =
      SparkSession.builder()
        .appName(AppConfig.appName)
        .master(AppConfig.sparkMaster)
        .getOrCreate()

    using(sparkSession) { implicit sparkSession =>
      println(count(readDataFromSource))
    }
  }
}
