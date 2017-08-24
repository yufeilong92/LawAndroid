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
 * 时间 :2017/3/13 14:04:14:04
 * 作用 :
 */
public class SettringPageFragment extends Fragment {
    private static final String PARAM1 = "param1";
    private static final String PARAM2 = "param2";
    public String mParam1,mParam2 ;

    public static SettringPageFragment OnNewIntent(String param1, String param2){
       SettringPageFragment fragment = new SettringPageFragment();
       Bundle bundle = new Bundle();
       bundle.putString(PARAM1,param1);
       bundle.putString(PARAM2,param1);
       fragment.setArguments(bundle);
       return fragment;
   }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() !=null){
            mParam1=getArguments().getString(PARAM1);
            mParam2=getArguments().getString(PARAM2);
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settring_page, null);
      return view;
    }
}
