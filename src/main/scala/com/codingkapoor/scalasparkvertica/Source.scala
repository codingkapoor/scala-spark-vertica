package com.codingkapoor.scalasparkvertica

import org.apache.spark.sql.{DataFrame, SparkSession}

sealed trait Source {
  def format: String

  def opts: Map[String, String]

  def readDataFromSource(implicit sparkSession: SparkSession): DataFrame = {
    sparkSession.sqlContext.read.format(format).options(opts).load()
  }
}

trait Vertica extends Source {
  override def format: String = VERTICA_DATA_SOURCE

  override def opts: Map[String, String] = Map(
    "host" -> Config.verticaHost,
    "user" -> Config.verticaUser,
    "password" -> Config.verticaPassword,
    "db" -> Config.verticaDB,
    "table" -> Config.verticaTable,
    "numPartitions" -> Config.verticaPartitions
  )
}
