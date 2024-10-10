package com.evolution.sparktest
import org.apache.spark.sql.SparkSession

object SparkTest extends App {

  def createConf(): SparkSession = {
    SparkSession.builder()
      .appName("Simple Application")
      .master("local[*]")
      .config("spark.authenticate", "false")
      .getOrCreate()
  }

  def endSpark(spark: SparkSession): Unit = {
    spark.stop()
  }

  def process(spark: SparkSession, data: Seq[(String, Int)]): String = { //trivial representation of spark job
    import spark.implicits._
    val df = data.toDF("name", "value")
    df.toJSON.collect().mkString("[", ",", "]")
  }

}

//sbt run