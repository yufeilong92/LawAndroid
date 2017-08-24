package com.lawyee.lawyeehelper2.view;

import com.lawyee.lawyeehelper2.adapter.MyHolder;
import com.lawyee.lawyeehelper2.vo.General_data;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 14:05
 * 作用 :
 */
public interface ToolAtyView {
    void SendJsonData(General_data data);

    void SendError(String string);

    void sendTreeValue(MyHolder.IconTreeItem value);

}
