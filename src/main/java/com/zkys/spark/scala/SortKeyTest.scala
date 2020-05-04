package com.zkys.spark.scala

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by fiona on 22/3/2017.
  */
object SortKeyTest {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SortKeyTest").setMaster("local[4]");
    val sc = new SparkContext(conf)


    val list = List(Tuple2(new SortKey(30,20,25),1),Tuple2(new SortKey(35,20,25),2),Tuple2(new SortKey(30,25,25),3))

     val rdd = sc.parallelize(list)
     val sortedRdd = rdd.sortByKey(false)

    for (rdd<-sortedRdd.collect()){
       println(rdd._2)
    }

  }
}
