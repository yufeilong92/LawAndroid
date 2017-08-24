package com.lawyee.lawyeehelper2.DateMessager;

import android.content.Context;
import android.widget.RelativeLayout;

import com.lawyee.lawyeehelper2.listenter.ToolListener;
import com.lawyee.lawyeehelper2.vo.General_data;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 16:32
 * 作用 :
 */
public interface ToolDataManger {
    void getData(Context mContext, ToolListener listener);



    void addTreeView(General_data mdata, RelativeLayout rlToolShowtree);

}
