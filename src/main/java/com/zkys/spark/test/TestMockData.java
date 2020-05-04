package com.zkys.spark.test;

import com.zkys.spark.conf.ConfigurationManager;
import com.zkys.spark.constant.Constants;
import com.zkys.spark.session.CategorySortKey;
import com.zkys.spark.util.SparkUtils;
import it.unimi.dsi.fastutil.ints.IntList;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;

/**
 * Created by fiona on 21/3/2017.
 */
public class TestMockData {
    public static void main(String[] args) {

        // 构建Spark上下文
        SparkConf conf = new SparkConf()
                .setAppName(Constants.SPARK_APP_NAME_SESSION)
//				.set("spark.default.parallelism", "100")
                .set("spark.storage.memoryFraction", "0.5")
                .set("spark.shuffle.consolidateFiles", "true")
                .set("spark.shuffle.file.buffer", "64")
                .set("spark.shuffle.memoryFraction", "0.3")
                .set("spark.reducer.maxSizeInFlight", "24")
                .set("spark.shuffle.io.maxRetries", "60")
                .set("spark.shuffle.io.retryWait", "60")
                .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .registerKryoClasses(new Class[]{
                        CategorySortKey.class,
                        IntList.class});
        SparkUtils.setMaster(conf);

        /**
         * 比如，获取top10热门品类功能中，二次排序，自定义了一个Key
         * 那个key是需要在进行shuffle的时候，进行网络传输的，因此也是要求实现序列化的
         * 启用Kryo机制以后，就会用Kryo去序列化和反序列化CategorySortKey
         * 所以这里要求，为了获取最佳性能，注册一下我们自定义的类
         */

        JavaSparkContext sc = new JavaSparkContext(conf);
//		sc.checkpointFile("hdfs://");
        SQLContext sqlContext = getSQLContext(sc.sc());

        // 生成模拟测试数据
        SparkUtils.mockData(sc, sqlContext);


    }

    private static SQLContext getSQLContext(SparkContext sc) {
        boolean local = ConfigurationManager.getBoolean(Constants.SPARK_LOCAL);
        if(local) {
            return new SQLContext(sc);
        } else {
            return new HiveContext(sc);
        }
    }



}
