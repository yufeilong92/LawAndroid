package com.lawyee.lawyeehelper2.ui.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.ui.Practical_tools_Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/13 13:42
 * 作用 :
 */
public class HomePageFragment extends Fragment {
    public static final String PARMTER1 = "param1";
    public static final String PARMTER2 = "param2";
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.tv_retrieval_)
    TextView tvRetrieval;
    @BindView(R.id.tv_manual)
    TextView tvManual;
    @BindView(R.id.tv_tool)
    TextView tvTool;
    private String mParam1, mParam2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(PARMTER1);
            mParam2 = getArguments().getString(PARMTER2);
        }
    }

    public static HomePageFragment OnNewIntent(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(PARMTER1, param1);
        args.putString(PARMTER2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.tv_search, R.id.tv_retrieval_, R.id.tv_manual, R.id.tv_tool})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:

                Toast.makeText(getActivity(),"tv_search",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_retrieval_:
                Toast.makeText(getActivity(),"tv_retrieval_",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_manual:
                Toast.makeText(getActivity(),"tv_manual",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_tool:
                Toast.makeText(getActivity(),"tool",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),Practical_tools_Activity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
    
}
