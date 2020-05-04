package com.zkys.spark.test;

/**
 * Created by fiona on 20/3/2017.
 */

/**
 * 单例模式  整个程序运行期间只有一个实例对象
 * 应用场景
 * 1 配置管理组件,可以在读取大量的配置信息之后,用单列模式的方式,就将配置信息仅仅存在一个实例变量中
 * 这样可以避免对于静态不变的配置信息,反复多次的读取
 * 2 JDBC辅助组件
 */
public class Singleton {

    private static Singleton  instance = null;
    private Singleton() {

    }

    public static Singleton getInstance(){
     // 两步检查
       if (instance == null){
          synchronized (Singleton.class){
              if (instance ==null) {
                  instance = new Singleton();
              }
          }

       }
        return  instance;


    }
}
