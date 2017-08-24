package com.lawyee.lawyeehelper2.presenter.PresenteImpl;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.listenter.TimeListener;
import com.lawyee.lawyeehelper2.presenter.TimePresenter;
import com.lawyee.lawyeehelper2.view.FragmentView;
import com.lawyee.lawyeehelper2.vo.DataVo;

import static android.content.ContentValues.TAG;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/16 16:14
 * 作用 :
 */
public class TimePresenterImpl implements TimePresenter ,TimeListener,View.OnClickListener {
    private final FragmentView fragmentview;
    Context mContext;
    private Button mBtnSelectdataCal;
    private Button mBtnSelectdataConfirm;
    private DatePicker mDatapicker;
    private DataVo dataVo;
    private Dialog daialog;
    int mark;


    public TimePresenterImpl(FragmentActivity activity, FragmentView fragmentView) {
        this.mContext = activity;
        this.fragmentview = fragmentView;
    }


    @Override
    public void showData(int i) {
        this.mark=i;
        daialog = new Dialog(mContext);
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.dialog_selectdata, null);
        daialog.setContentView(inflate);
        daialog.setCancelable(true);
        daialog.show();

        initView(inflate);
    }

    private void initView(View view) {
        mBtnSelectdataCal = (Button) view.findViewById(R.id.btn_selectdata_cal);
        mBtnSelectdataConfirm = (Button) view.findViewById(R.id.btn_selectdata_confirm);
        mBtnSelectdataConfirm.setOnClickListener(this);
        mBtnSelectdataCal.setOnClickListener(this);
        mDatapicker = (DatePicker) view.findViewById(R.id.datapicker);
    }

    private void getData() {
        int year = mDatapicker.getYear();
        int month = mDatapicker.getMonth()+1;
        int data = mDatapicker.getDayOfMonth();
        dataVo = new DataVo();
        dataVo.setYear(year);
        dataVo.setData(data);
        dataVo.setMonth(month);
        Log.d(TAG, "initView: 年"+year+"月="+month+"日="+data);
        if (mark==0){
        fragmentview.sendStartTime(dataVo);
            daialog.dismiss();
        }else if (mark==1){
        fragmentview.sendEndTime(dataVo);
            daialog.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_selectdata_cal:
                daialog.dismiss();
                break;
            case  R.id.btn_selectdata_confirm:
              getData();
               break;
        }
    }
}
