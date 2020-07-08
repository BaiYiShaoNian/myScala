package com.scala.learn.base

import scala.collection.immutable
import scala.collection.mutable

/**
  * Create by huangxuanfeng on 2020/7/7 上午11:04
  */
object HelloScala {

  def main(args: Array[String]): Unit = {
    println(args.length)
    println("hello")

    var a: String = null
    println(a)
    a = "huang"
    println(a.toUpperCase + "  " + a.toUpperCase())

    val b: String =
      """
        |hello, 我是 %s
      """.stripMargin
    println(b.format("huang"))
    println(b.format("zhang"))

    var aa, bb: Int = 10
    println(aa + " " + bb)
    aa = 100
    println(aa + " " + bb)
    var a0, b0: String = "huang"
    println(a0 + " " + b0)
    a0 = "黄"
    println(a0 + " " + b0)

    println(getUpper("huang"))
    val c: (String, String) = getUpper("xuan")
    println(c._2 + " " + c._1)

    getArr()

    val pattern = a.r
    println(pattern.findFirstIn("huangxuanfenghuang"))

    getSet()

  }

  def getSet(): Unit = {
    val set1 = immutable.Set(1,2,3)
    set1.foreach(println)
    println(set1)

    val set2 = mutable.Set(1,2,3)
    set2 += 10
    set2.add(100)
    set2.foreach(println)
    println(set2(3) + " " + set2.size)

    val set3: mutable.Set[String] = mutable.Set[String]()
    set3.add("huang")
    set3.add("xuan")
    set3.add("feng")
    println(set3)
    println(set3.mkString(","))
    println(set3.mkString("huang", ":", "xuan"))

    println(set2.apply(10))
    println(set2.init)
    println(set2.toArray.apply(2))

    for (i <- set3) {
      print(i + " ")
    }
  }

  def getArr(): Unit = {
    val a: Array[Int] = new Array[Int](3)
    a(0) = 100
    a(1) = 200
    a.foreach(println)
  }

  def getUpper(a: String): (String, String) = {
    (a, a.toUpperCase)
  }

}
