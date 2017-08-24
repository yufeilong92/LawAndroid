package com.lawyee.lawyeehelper2.vo;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 14:56
 * 作用 :
 */
public class ToolData {
    public static General_data getJson(Context context) throws IOException {
        InputStream inputStream = context.getAssets().open("toolsConfig.json");
        General_data data = new GsonBuilder().create().fromJson(new InputStreamReader(inputStream), General_data.class);
         return data;
    }
}
