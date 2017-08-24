package com.lawyee.lawyeehelper2.listenter;

import com.lawyee.lawyeehelper2.adapter.MyHolder;
import com.lawyee.lawyeehelper2.vo.General_data;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 16:38
 * 作用 :
 */
public interface ToolListener {

    void SendJson(General_data data);

    void SendTreeData(MyHolder.IconTreeItem value);
}
