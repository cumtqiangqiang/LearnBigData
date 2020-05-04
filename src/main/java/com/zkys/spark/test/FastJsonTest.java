package com.zkys.spark.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by fiona on 21/3/2017.
 */
public class FastJsonTest {

    public static void main(String[] args) {

        String json = "[{\"name\":\"feng\"}]";

        JSONArray jsonArray = JSON.parseArray(json);
        JSONObject obj = jsonArray.getJSONObject(0);
        System.out.println(obj.get("name"));
    }

}
