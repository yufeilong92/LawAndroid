package com.lawyee.lawyeehelper2.presenter;

import android.support.v4.app.FragmentManager;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/16 11:30
 * 作用 :
 */
public interface DataPresenter {
    void addNormal_calculation(FragmentManager fragmentTransaction);

    void replacefragment(FragmentManager fragmentTransaction);

    void addfragment(FragmentManager fm);
}
