package com.lawyee.lawyeehelper2.presenter;

import android.support.v4.app.Fragment;

import com.lawyee.lawyeehelper2.view.TabAtyview;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/13 11:09
 * 作用 :
 */
public interface TabPresener {

    void findTab_button();

    void setTab_button(TabAtyview tabAtyview, ArrayList<String> list);


    void addTitles(List<String> mTitles, String[] mBtn_string, List<Fragment> mFragments);

}
