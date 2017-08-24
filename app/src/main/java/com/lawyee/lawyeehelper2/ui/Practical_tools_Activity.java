package com.lawyee.lawyeehelper2.ui;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.adapter.MyHolder;
import com.lawyee.lawyeehelper2.presenter.PresenteImpl.ToolPresenterImpl;
import com.lawyee.lawyeehelper2.presenter.ToolPresenter;
import com.lawyee.lawyeehelper2.view.ToolAtyView;
import com.lawyee.lawyeehelper2.vo.General_data;

import butterknife.BindView;
import butterknife.OnClick;

public class Practical_tools_Activity extends BaseActivity implements ToolAtyView {
    public static final String TAG = "流程查询";
    @BindView(R.id.imgBtn_toolbar_back)
    ImageButton imgBtnToolbarBack;
    @BindView(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;
    @BindView(R.id.imgBtn_toolbar_home)
    ImageButton imgBtnToolbarHome;
    @BindView(R.id.toobars)
    Toolbar toobars;

    General_data mdata;

    @BindView(R.id.rl_tool_showtree)
    RelativeLayout rlToolShowtree;

    private ToolPresenter toolPresenter;
    private TextView mTvToolFirsthead;


    @Override
    protected int getContentviewID() {
        return R.layout.activity_practical_tools_;

    }

    @Override
    protected void initView() {
        toolPresenter = new ToolPresenterImpl(this, this);
    }

    @Override
    protected void initContent() {
        toolPresenter.getJson();
        toolPresenter.addTreeView(mdata,rlToolShowtree);


    }




    @Override
    protected void initToolbar() {
        setSupportActionBar(toobars);
        toobars.setEnabled(false);
        tvToolbarTitle.setText(R.string.tools);
        tvToolbarTitle.setEnabled(false);
    }

    @OnClick({R.id.imgBtn_toolbar_back, R.id.tv_toolbar_title, R.id.imgBtn_toolbar_home, R.id.toobars})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtn_toolbar_back:
                goBack();
                break;
            case R.id.tv_toolbar_title:
                Toast.makeText(Practical_tools_Activity.this, "2222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgBtn_toolbar_home:
                break;
            case R.id.toobars:
                break;
        }
    }

    @Override
    public void SendJsonData(General_data data) {

        this.mdata = data;
        Log.e(TAG, "onClick: " + data.getText() + data.getItems());


    }


    @Override
    public void SendError(String string) {
        showError(string);
    }

    /**
     *  点击工具的回调
     * @param value
     */
    @Override
    public void sendTreeValue(MyHolder.IconTreeItem value) {
        Toast.makeText(Practical_tools_Activity .this,""+value.getTv_item(),Toast.LENGTH_SHORT).show();
        toolPresenter.startIntent(this,value);
    }

}
