package com.lawyee.lawyeehelper2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.vo.General_data;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 17:26
 * 作用 :
 */
public class ToolAdapter extends BaseAdapter {


    private List<General_data.ItemsBeanX> mData;
    private Context mContext;
    private final LayoutInflater inflater;

    public ToolAdapter(General_data mData, Context mContext) {
        List<General_data.ItemsBeanX> items = mData.getItems();
        this.mData = items;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData == null ? null : mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View converview, ViewGroup viewGroup) {
        ViewHolder holder;
        if (converview == null) {
            converview = inflater.inflate(R.layout.item_tool_listview, null);
            holder = new ViewHolder(converview,mContext);
            converview.setTag(converview);
        } else {
            holder = (ViewHolder) converview.getTag();
        }
        holder.lvShowItem.setText(mData.get(i).getText());
        return converview;
    }



    static class ViewHolder {
        @BindView(R.id.lv_showItem)
        TextView lvShowItem;
        ViewHolder(View view, final Context context) {
            ButterKnife.bind(this, view);
              lvShowItem.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                   Toast.makeText(context,"你点击",Toast.LENGTH_SHORT).show();
                  }
              });
        }
    }


}
