package com.zkys.spark.test;

import com.zkys.spark.jdbc.JDBCHelper;
import org.apache.avro.generic.GenericData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fiona on 21/3/2017.
 */
public class JDBCHelperTest {

    public static void main(String[] args) {
        JDBCHelper  helper = JDBCHelper.getInstance();

//       String sql = "insert into ts_users (name,age) values(?,?)";
//        helper.executeUpdate(sql,new Object[]{"哈哈你强",72});
//
//        System.out.printf("over");

//       查询语句
//        helper.executeQuery("select*from ts_users where id = ?", new Object[]{8}, new JDBCHelper.QueryCallback() {
//            @Override
//            public void process(ResultSet rs) throws Exception {
//
//                while (rs.next()){
//                    java.lang.String name = rs.getString(2);
//                    int age = rs.getInt(3);
//                    System.out.println(name +":"+ age);
//                }
//
//            }
//        });

        String sql1 = "insert into ts_users (name,age) values(?,?)";
        List<Object[]> param = new ArrayList<Object[]>();
        param.add(new Object[]{"喝了咯",101});
        helper.executeBatch(sql1,param);






    }





}
