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

  object Config {
    final lazy val appConf: Config = ConfigFactory.load().getConfig("scala_spark_vertica")
    final lazy val appName = appConf.getString("appName")
    final lazy val sparkMaster = appConf.getString("spark.master")
    final lazy val verticaHost = appConf.getString("vertica.host")
    final lazy val verticaUser = appConf.getString("vertica.user")
    final lazy val verticaPassword = appConf.getString("vertica.password")
    final lazy val verticaDB = appConf.getString("vertica.db")
    final lazy val verticaTable = appConf.getString("vertica.table")
    final lazy val verticaPartitions = appConf.getString("vertica.partitions")
  }
}
