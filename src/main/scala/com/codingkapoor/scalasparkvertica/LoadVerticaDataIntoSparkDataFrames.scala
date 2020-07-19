package com.codingkapoor.scalasparkvertica

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.SparkConf

object LoadVerticaDataIntoSparkDataFrames {
  def main(args: Array[String]): Unit = {
    val sparkSession =
      SparkSession.builder()
      .appName("vertica-spark-connector")
      .master("local[*]")
      .getOrCreate()

    val host = "192.168.1.9"
    val db = "glassbeam"
    val table = "test"
    val user = "dbadmin"
    val password = "dbadmin123"
    val partitions = "4"

    val opt = Map(
      "host" -> host,
      "user" -> user,
      "password" -> password,
      "db" -> db,
      "table" -> table,
      "numPartitions" -> partitions
    )

    val df: DataFrame = sparkSession.sqlContext.read.format("com.vertica.spark.datasource.DefaultSource").options(opt).load()

    val c: Long = df.select("a").filter("a > 5").count()
    println(c)

    sparkSession.stop()
  }
}
