package com.lawyee.lawyeehelper2.presenter;

import android.widget.RelativeLayout;

import com.lawyee.lawyeehelper2.adapter.MyHolder;
import com.lawyee.lawyeehelper2.ui.Practical_tools_Activity;
import com.lawyee.lawyeehelper2.vo.General_data;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 10:42
 * 作用 :
 */
public interface ToolPresenter {
    void getJson();

    void addTreeView(General_data mdata, RelativeLayout rlToolShowtree);

    void startIntent(Practical_tools_Activity aty, MyHolder.IconTreeItem value);
}
