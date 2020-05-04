package com.zkys.spark.scala

/**
  * Created by fiona on 22/3/2017.
  */
class SortKey(val clickCount:Int,val orderCount:Int,val payCount:Int)
        extends Ordered[SortKey] with Serializable{
   def compare(that: SortKey): Int = {

    if (clickCount - that.clickCount!=0){
      return clickCount -that.clickCount
    }else if(orderCount - that.orderCount!=0){
      return orderCount-that.orderCount
    }else if (payCount - that.payCount != 0){

      return payCount-that.payCount
    }else{
      0
    }

  }
}
