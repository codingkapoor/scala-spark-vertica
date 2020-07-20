package com.codingkapoor.scalasparkvertica

import com.typesafe.config.{Config, ConfigFactory}

object `package` {
  final lazy val VERTICA_DATA_SOURCE = "com.vertica.spark.datasource.DefaultSource"

  def using[A <: {def stop(): Unit}, B](resource: A)(f: A => Unit): Unit = {
    try {
      f(resource)
    } finally {
      resource.stop()
    }
  }

  object AppConfig {
    final lazy val conf: Config = ConfigFactory.load().getConfig("scala_spark_vertica")
    final lazy val appName = conf.getString("appName")
    final lazy val sparkMaster = conf.getString("spark.master")
    final lazy val verticaHost = conf.getString("vertica.host")
    final lazy val verticaUser = conf.getString("vertica.user")
    final lazy val verticaPassword = conf.getString("vertica.password")
    final lazy val verticaDB = conf.getString("vertica.db")
    final lazy val verticaTable = conf.getString("vertica.table")
    final lazy val verticaPartitions = conf.getString("vertica.partitions")
  }
}
