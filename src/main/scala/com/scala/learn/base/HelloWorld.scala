package com.scala.learn.base

import org.apache.spark.sql.SparkSession

/**
  * Create by huangxuanfeng on 2020/4/9 下午11:49
  */
object HelloWorld {

  def main(args: Array[String]): Unit = {
    val hello: String = "hello, huangxuanfeng"
    println(hello)

    val spark = SparkSession.builder()
      .enableHiveSupport()
      .appName(this.getClass.getSimpleName)
      .getOrCreate()



    spark.stop()
  }
}
