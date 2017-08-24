package com.lawyee.lawyeehelper2.ui.Fragment;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.presenter.PresenteImpl.TimePresenterImpl;
import com.lawyee.lawyeehelper2.presenter.TimePresenter;
import com.lawyee.lawyeehelper2.view.FragmentView;
import com.lawyee.lawyeehelper2.vo.DataVo;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.os.Build.VERSION_CODES.N;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/15 14:54
 * 作用 :
 */
public class DataFragment extends Fragment implements FragmentView {
    public static final String PARAM1 = "com.lawyee.param1";
    public static final String PARAM2 = "com.lawyee.param2";
    String param1, param2;
    @BindView(R.id.tv_starttime)
    TextView tvStarttime;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tv_endtime)
    TextView tvEndtime;
    @BindView(R.id.tv_showData)
    TextView tvShowData;
    private Button mBtnSelectdataCal;
    private Button mBtnSelectdataConfirm;
    private DatePicker mDatapicker;
    private TimePresenter presenter;
    private DataVo mDataTime;

    public static DataFragment onNewIntent(String param1, String param2) {
        DataFragment fragment = new DataFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM1, param1);
        bundle.putString(PARAM2, param2);
        fragment.setArguments(bundle);
        return fragment;
    }

    @TargetApi(N)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString(PARAM1);
            param2 = getArguments().getString(PARAM2);
        }
        presenter = new TimePresenterImpl(getActivity(), this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, null);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.tv_starttime, R.id.textView, R.id.tv_endtime, R.id.tv_showData})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_starttime:
                presenter.showData(0);
                break;
            case R.id.textView:
                break;
            case R.id.tv_endtime:
                presenter.showData(1);
                break;
            case R.id.tv_showData:
                break;
        }
    }

    @Override
    public void sendStartTime(DataVo dataVo) {
        this.mDataTime = dataVo;
        tvStarttime.setText(dataVo.getYear() + "/" + dataVo.getMonth() + "/" + dataVo.getData());
    }

    @Override
    public void sendEndTime(DataVo dataVo) {
        tvEndtime.setText(dataVo.getYear() + "/" + dataVo.getMonth() + "/" + dataVo.getData());

    }
}
