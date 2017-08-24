package com.lawyee.lawyeehelper2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lawyee.lawyeehelper2.R;
import com.unnamed.b.atv.model.TreeNode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/15 09:14
 * 作用 :
 */
public class MyHolder extends TreeNode.BaseNodeViewHolder<MyHolder.IconTreeItem> {

    private ViewHolder holder;

    public MyHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, IconTreeItem value) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View treeview = inflater.inflate(R.layout.item_tool_tree, null);
        holder = new ViewHolder(treeview);
        holder.imgToolitemHead.setImageResource(value.getIc_head());
        holder.tvToolitemElement.setText(value.getTv_item());
        return treeview;
    }


        public static class IconTreeItem {
        String tv_item;
         int ic_head;


        public String getTv_item() {
            return tv_item;
        }

        public void setTv_item(String tv_item) {
            this.tv_item = tv_item;
        }

        public int getIc_head() {
            return ic_head;
        }

        public void setIc_head(int ic_head) {
            this.ic_head = ic_head;
        }
    }

    static class ViewHolder {
        @BindView(R.id.img_toolitem_head)
        ImageView imgToolitemHead;
        @BindView(R.id.tv_toolitem_element)
        TextView tvToolitemElement;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);

        }
    }
}
