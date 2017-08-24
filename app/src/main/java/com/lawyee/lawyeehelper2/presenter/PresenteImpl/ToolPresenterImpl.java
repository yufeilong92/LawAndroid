package com.lawyee.lawyeehelper2.presenter.PresenteImpl;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;

import com.lawyee.lawyeehelper2.DateMessager.impl.ToolDataMangerImpl;
import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.adapter.MyHolder;
import com.lawyee.lawyeehelper2.listenter.ToolListener;
import com.lawyee.lawyeehelper2.presenter.ToolPresenter;
import com.lawyee.lawyeehelper2.ui.DataActivity;
import com.lawyee.lawyeehelper2.ui.Practical_tools_Activity;
import com.lawyee.lawyeehelper2.view.ToolAtyView;
import com.lawyee.lawyeehelper2.vo.General_data;

import static com.lawyee.lawyeehelper2.R.string.Date_Calculation;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 14:04
 * 作用 :
 */
public class ToolPresenterImpl implements ToolPresenter, ToolListener {
    private Context mContext;
    private ToolAtyView atyView;
    private final ToolDataMangerImpl dataMangerger;

    public static final String DATA="datacalculation";

    public ToolPresenterImpl(Context mContext, ToolAtyView atyView) {
        this.mContext = mContext;
        this.atyView = atyView;
        dataMangerger = new ToolDataMangerImpl();
    }

    @Override
    public void getJson() {
        if (atyView != null) {
            dataMangerger.getData(mContext, this);
        }
    }


    @Override
    public void SendJson(General_data data) {
        if (data != null && atyView != null) {
            atyView.SendJsonData(data);
        } else {
            atyView.SendError(mContext.getString(R.string.SendError));
            dataMangerger.getData(mContext, this);
        }
    }

    @Override
    public void SendTreeData(MyHolder.IconTreeItem value) {
        if (atyView != null && value != null) {
            atyView.sendTreeValue(value);
        } else {
            throw new IllegalArgumentException("参数异常");
        }
    }


    @Override
    public void addTreeView(General_data mdata, RelativeLayout rlToolShowtree) {
        if (mdata != null) {
            dataMangerger.addTreeView(mdata, rlToolShowtree);
        } else {
            throw new IllegalArgumentException("参数异常");
        }

    }

    @Override
    public void startIntent(Practical_tools_Activity aty, MyHolder.IconTreeItem value) {
        if (value != null) {
            String data = aty.getResources().getString(Date_Calculation);
            if (value.getTv_item().equals(data)) {
                Intent intent = new Intent(aty, DataActivity.class);
                intent.putExtra(DATA,data);
                aty.startActivity(intent);
            }
        } else {
            throw new IllegalArgumentException("参数异常");
        }
    }

}
