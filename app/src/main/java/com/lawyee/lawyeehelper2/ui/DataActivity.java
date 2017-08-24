package com.lawyee.lawyeehelper2.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.presenter.DataPresenter;
import com.lawyee.lawyeehelper2.presenter.PresenteImpl.DataPresenterImpl;
import com.lawyee.lawyeehelper2.view.DataView;

import butterknife.BindView;
import butterknife.OnClick;

public class DataActivity extends BaseActivity implements DataView {


    @BindView(R.id.imgBtn_toolbar_back)
    ImageButton imgBtnToolbarBack;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.imgBtn_toolbar_home)
    ImageButton imgBtnToolbarHome;
    @BindView(R.id.toobars)
    Toolbar toobars;
    @BindView(R.id.fragment)
    FrameLayout fragment;

    public static final String PARAM1 = "com.lawyee.dataparam1";
    public static final String PARAM2 = "com.lawyee.dataparam2";
    @BindView(R.id.rdobtn_routine)
    RadioButton rdobtnRoutine;
    @BindView(R.id.rdobtn_word)
    RadioButton rdobtnWord;


    private DataPresenter dataPresenter;

    private FragmentManager fm;

  /*  @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ButterKnife.bind(this);

    }*/

    public Intent newIntent(Context context, String param1, String param2) {
        Intent intent = new Intent(context, DataActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(PARAM1, param1);
        bundle.putString(PARAM2, param2);
        intent.putExtras(bundle);
        return intent;
    }

    @Override
    protected int getContentviewID() {
        return R.layout.activity_data;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(toobars);
        tvToolbarTitle.setText(R.string.Date_Calculation);
    }

    @Override
    protected void initView() {
        dataPresenter = new DataPresenterImpl(this, this);
        fm = getSupportFragmentManager();

    }

    @Override
    protected void initContent() {
        if (rdobtnRoutine.isChecked()) {
             dataPresenter.addfragment(fm);
        }
    }

    @OnClick({R.id.imgBtn_toolbar_back, R.id.tv_toolbar_title, R.id.imgBtn_toolbar_home, R.id.toobars, R.id.rdobtn_routine, R.id.rdobtn_word})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtn_toolbar_back:
                goBack();
                break;
            case R.id.tv_toolbar_title:
                break;
            case R.id.imgBtn_toolbar_home:
                break;
            case R.id.toobars:
                break;
            case R.id.rdobtn_routine:
                dataPresenter.addNormal_calculation(fm);
                break;
            case R.id.rdobtn_word:
             dataPresenter.replacefragment(fm);
                break;
        }

    }
}
