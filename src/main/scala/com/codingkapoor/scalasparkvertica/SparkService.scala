package com.codingkapoor.scalasparkvertica

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.SparkConf

trait SparkService {
  def count(df: DataFrame): Long = {
    df.select("a").filter("a > 5").count()
  }
}
