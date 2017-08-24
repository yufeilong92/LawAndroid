package com.lawyee.lawyeehelper2.ui.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lawyee.lawyeehelper2.R;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/16 11:07
 * 作用 :
 */
public class DataWrokFragment extends Fragment {

    private static final String PARAM1 = "com.lawyee.com.param1";
    private static final String PARAM2 = "com.lawyee.com.param2";

    String param1,param2;
    public static DataWrokFragment onNewIntent(String param1, String param2){
        DataWrokFragment fragment = new DataWrokFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM1,param1);
        bundle.putString(PARAM2,param2);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            param1=getArguments().getString(PARAM1);
            param2=getArguments().getString(PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workdata, null);

        return view;


    }
}
