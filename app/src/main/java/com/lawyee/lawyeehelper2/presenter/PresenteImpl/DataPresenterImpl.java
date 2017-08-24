package com.lawyee.lawyeehelper2.presenter.PresenteImpl;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.listenter.DataListener;
import com.lawyee.lawyeehelper2.presenter.DataPresenter;
import com.lawyee.lawyeehelper2.ui.Fragment.DataFragment;
import com.lawyee.lawyeehelper2.ui.Fragment.DataWrokFragment;
import com.lawyee.lawyeehelper2.view.DataView;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/16 11:30
 * 作用 :
 */
public class DataPresenterImpl implements DataPresenter, DataListener {
    Fragment fragments = null;
    Context mContent;
    DataView dataView;

    public DataPresenterImpl(Context context, DataView dataView) {
        this.mContent = context;
        this.dataView = dataView;
    }

    @Override
    public void addNormal_calculation(FragmentManager fm) {

        switchContent(fm, getfragment(1), getfragment(0));
    }

    @Override
    public void replacefragment(FragmentManager fm) {
        switchContent(fm, getfragment(0), getfragment(1));
    }

    @Override
    public void addfragment(FragmentManager fm) {
        fragments = getfragment(0);
        fm.beginTransaction().add(R.id.fragment, getfragment(0)).commit();
    }

    /**
     * fragment 切换
     *
     * @param from
     * @param to
     */


    public void switchContent(FragmentManager fm, Fragment from, Fragment to) {
        if (fragments != to) {
            fragments = to;
            FragmentTransaction transaction = fm.beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(from).add(R.id.fragment, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

    private Fragment getfragment(int a) {
        switch (a) {
            case 0:
                return new DataFragment();
            case 1:
                return new DataWrokFragment();
            default:
                return new DataFragment();
        }
    }

}
