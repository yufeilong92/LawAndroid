package com.lawyee.lawyeehelper2.view;

import android.support.v4.app.Fragment;

import java.util.List;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/13 11:09
 * 作用 :
 */
public interface TabAtyview {


    void SendString(String[] stringArray);

    void sendTitles(List<String> mTitles, List<Fragment> mFragments);

}
