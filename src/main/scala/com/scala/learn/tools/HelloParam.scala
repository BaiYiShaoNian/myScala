package com.scala.learn.tools

import org.apache.spark.sql.SparkSession

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
