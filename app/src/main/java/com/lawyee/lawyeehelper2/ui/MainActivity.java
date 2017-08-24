package com.lawyee.lawyeehelper2.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.adapter.MainAdapter;
import com.lawyee.lawyeehelper2.presenter.PresenteImpl.TabPresenterImpl;
import com.lawyee.lawyeehelper2.presenter.TabPresener;
import com.lawyee.lawyeehelper2.view.TabAtyview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements TabAtyview {


    private static final String TAG = "查询结果";
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.imgBtn_toolbar_back)
    ImageButton imgBtnToolbarBack;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.imgBtn_toolbar_home)
    ImageButton imgBtnToolbarHome;
    @BindView(R.id.toobars)
    Toolbar toobars;
    private TabPresener presenter;
    private String[] mBtn_String;
    private List<String> mTitles = new ArrayList<>();

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getContentviewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        presenter = new TabPresenterImpl(MainActivity.this, this);
        initToolbar();

    }
    @Override
     protected void initToolbar() {
        bar.hide();
        tvToolbarTitle.setText(R.string.Assistant_system);
        tvToolbarTitle.setEnabled(false);
        imgBtnToolbarBack.setVisibility(View.GONE);
        imgBtnToolbarHome.setVisibility(View.GONE);
    }


    @Override
    protected void initContent() {

        presenter.findTab_button();
        presenter.addTitles(mTitles, mBtn_String, mFragments);
        Log.e(TAG, "initContent: " + mFragments.size());
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), mTitles, mFragments);
        viewpager.setAdapter(adapter);

        tabs.setupWithViewPager(viewpager);
        tabs.setTabsFromPagerAdapter(adapter);
    }

    /**
     * @param stringArray tab_button查询出来的结果
     */
    @Override
    public void SendString(String[] stringArray) {
        this.mBtn_String = stringArray;
    }

    /**
     * @param mTitles    加载回调
     * @param mFragments
     */
    @Override
    public void sendTitles(List<String> mTitles, List<Fragment> mFragments) {
        this.mTitles = mTitles;
        this.mFragments = mFragments;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.imgBtn_toolbar_back, R.id.tv_toolbar_title, R.id.imgBtn_toolbar_home})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtn_toolbar_back:
                break;
            case R.id.tv_toolbar_title:
                break;
            case R.id.imgBtn_toolbar_home:
                break;
        }
    }
}
