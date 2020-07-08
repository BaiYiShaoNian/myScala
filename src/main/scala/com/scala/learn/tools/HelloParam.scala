package com.scala.learn.tools

import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.util._
import org.apache.spark.sql.types
import org.apache.spark.sql.test._
import org.apache.spark.sql.streaming._
import org.apache.spark.sql.sources._
import org.apache.spark.sql.jdbc._
import org.apache.spark.sql.internal._
import org.apache.spark.sql.hive._
import org.apache.spark.sql.expressions._
import org.apache.spark.sql.execution._
import org.apache.spark.sql.catalyst._
import org.apache.spark.sql.catalog._
import org.apache.spark.sql.api._
import org.apache.spark.sql.functions

/**
  * Create by huangxuanfeng on 2020/5/25 下午6:34
  */
object HelloParam {

  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      println("参数不对")
      return
    }

    val p1 = args(0)
    val p2 = args(1)

    println("这是spark输出,  " + p1)
    println("这是spark输出， " + p2)

    val spark = SparkSession
      .builder()
      .appName(this.getClass.getSimpleName)
      .enableHiveSupport()
      .getOrCreate()

    val r = spark.sparkContext.parallelize(List("这是spark输出,  " + p1, " 这是spark输出， " + p2))
    r.collect().foreach( println )

    import spark.implicits._

    println("select id,username,created_at from keep_ods.ods_user_users where p_date='2020-05-24' and username = '%s'".format(p2))

    val result = spark.sql("select id,username,created_at from keep_ods.ods_user_users where p_date='2020-05-24' and username = '%s'".format(p2))
    result.rdd.collect().foreach({
      println
    })
    result.collect().take(10)

    spark.stop()

  }
}
