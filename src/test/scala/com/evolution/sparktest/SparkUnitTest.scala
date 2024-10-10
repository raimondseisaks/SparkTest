package com.evolution.sparktest

import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}
import com.evolution.sparktest.SparkTest._
import org.apache.spark.sql.SparkSession

class SparkUnitTest extends FlatSpec with Matchers with BeforeAndAfterAll {
  var spark: SparkSession = _
  override def beforeAll(): Unit = spark = createConf()

  override def afterAll(): Unit = endSpark(spark)

  "Job1" should "return the correct results" in {
    val inputData = Seq(
      ("Alice", 1),
      ("Bob", 2),
      ("Cathy", 3),
      ("David", 4)
    )

    val outputData = "[{\"name\":\"Alice\",\"value\":1},{\"name\":\"Bob\",\"value\":2},{\"name\":\"Cathy\",\"value\":3},{\"name\":\"David\",\"value\":4}]"

    val df = SparkTest.process(spark, inputData)


    df should contain theSameElementsAs outputData
  }
  "Job2" should "return the correct results" in {
    val expectedData = Seq(
      ("Alice", 1),
      ("Bob", 2),
      ("Cathy", 3),
      ("David", 4)
    )

    val df1 = SparkTest.process(spark, expectedData)
    val df2 = SparkTest.process(spark, expectedData)
    println(df1)

    df1 should contain theSameElementsAs df2
  }
}


