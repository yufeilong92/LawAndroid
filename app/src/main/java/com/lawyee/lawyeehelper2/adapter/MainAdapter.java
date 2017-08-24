package com.lawyee.lawyeehelper2.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/6 15:06
 * 作用 :
 */
public class MainAdapter extends FragmentPagerAdapter {
    private ArrayList<String> mDate;

    private Context mcontext;
    List<String> title;
    List<Fragment> mfragments;

    public MainAdapter(FragmentManager fm , List<String> title, List<Fragment> fragments) {
        super(fm);
        this.title=title;
        this.mfragments=fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return title.get(position);

    }
}


