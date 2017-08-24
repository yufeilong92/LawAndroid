package com.lawyee.lawyeehelper2.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/6 14:54
 * 作用 :
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static ActionBar bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bar = getSupportActionBar();
        setContentView(getContentviewID());
        ButterKnife.bind(this);
        initToolbar();
        initView();
        initContent();


    }


    protected abstract int getContentviewID();

    protected abstract void initToolbar();

    protected abstract void initView();

    protected abstract void initContent();

    public void goBack() {
        finish();
    }

    public void showprogress(String title, String msg) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle(title);
        dialog.setMessage(msg);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.show();
    }

    public void showError(String msg) {
        Toast.makeText(BaseActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
    }
}
