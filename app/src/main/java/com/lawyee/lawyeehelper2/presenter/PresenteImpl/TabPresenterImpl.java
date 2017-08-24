package com.lawyee.lawyeehelper2.presenter.PresenteImpl;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.presenter.TabPresener;
import com.lawyee.lawyeehelper2.ui.Fragment.HelpFragment;
import com.lawyee.lawyeehelper2.ui.Fragment.HomePageFragment;
import com.lawyee.lawyeehelper2.ui.Fragment.SettringPageFragment;
import com.lawyee.lawyeehelper2.view.TabAtyview;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/13 11:08
 * 作用 :
 */
public class TabPresenterImpl implements TabPresener {
    Context mContext;
    TabAtyview tabAtyview;

    public TabPresenterImpl(Context mContext, TabAtyview tabAtyview) {
        this.mContext = mContext;
        this.tabAtyview = tabAtyview;
    }

    @Override
    public void findTab_button() {
        String[] stringArray = mContext.getResources().getStringArray(R.array.tab_botton);
        tabAtyview.SendString(stringArray);
    }

    @Override
    public void setTab_button(TabAtyview tabAtyview, ArrayList<String> list) {

    }

    @Override
    public void addTitles(List<String> mTitles, String[] mBtn_string, List<Fragment> mFragments) {
        mTitles.add(mBtn_string[0]);
        mTitles.add(mBtn_string[1]);
        mTitles.add(mBtn_string[2]);
        mFragments.add(new HomePageFragment());
        mFragments.add(new SettringPageFragment());
        mFragments.add(new HelpFragment());
        tabAtyview.sendTitles(mTitles, mFragments);
    }


}
