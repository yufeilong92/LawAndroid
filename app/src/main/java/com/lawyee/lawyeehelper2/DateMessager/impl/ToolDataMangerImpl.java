package com.lawyee.lawyeehelper2.DateMessager.impl;

import android.content.Context;
import android.widget.RelativeLayout;

import com.google.gson.GsonBuilder;
import com.lawyee.lawyeehelper2.DateMessager.ToolDataManger;
import com.lawyee.lawyeehelper2.R;
import com.lawyee.lawyeehelper2.adapter.MyHolder;
import com.lawyee.lawyeehelper2.listenter.ToolListener;
import com.lawyee.lawyeehelper2.vo.General_data;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者 : YFL  is Creating a porject in YFPHILPS
 * 邮箱 : yufeilong92@163.com
 * 时间 :2017/3/14 16:33
 * 作用 :
 */
public class ToolDataMangerImpl implements ToolDataManger {
    Context mContext;
    ToolListener listener;

    public void getData(Context mContext, ToolListener listener) {
        this.mContext = mContext;
        this.listener = listener;
        InputStream inputStream = null;
        try {
            inputStream = mContext.getAssets().open("toolsConfig.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        General_data data = new GsonBuilder().create().fromJson(new InputStreamReader(inputStream), General_data.class);
        listener.SendJson(data);
    }


    @Override
    public void addTreeView(final General_data mdata, final RelativeLayout rlToolShowtree) {
                TreeNode root = TreeNode.root();
                List<General_data.ItemsBeanX> items = mdata.getItems();
                ArrayList<TreeNode> parentlists = new ArrayList<>();
                ArrayList<TreeNode> elementlist = new ArrayList<>();
                //添加第一层元素

                for (int i = 0; i < items.size(); i++) {
                    General_data.ItemsBeanX itemsBeanX = items.get(i);

                    MyHolder.IconTreeItem iconTreeItem = new MyHolder.IconTreeItem();
                    iconTreeItem.setTv_item(itemsBeanX.getText());

                    TreeNode parent = new TreeNode(iconTreeItem).setViewHolder(new MyHolder(mContext));

                    if (elementlist.size() != 0) {
                        elementlist.clear();
                    }
                    //添加第二层元素
                    if (itemsBeanX.getItems() != null) {
                        int size = itemsBeanX.getItems().size();
                        if (size != 0) {
                            for (int j = 0; j < size; j++) {
                                General_data.ItemsBeanX.ItemsBean itemsBean = itemsBeanX.getItems().get(j);

                                MyHolder.IconTreeItem iconTreeItem1 = new MyHolder.IconTreeItem();
                                iconTreeItem1.setTv_item(itemsBean.getText());

                                TreeNode elementTree = new TreeNode(iconTreeItem1).setViewHolder(new MyHolder(mContext));

                                elementlist.add(elementTree);
                            }
                            if (elementlist.size() != 0) {
                                for (int q = 0; q < elementlist.size(); q++) {
                                    parent.addChildren(elementlist.get(q));

                                }
                            }
                        }
                    }
                    parentlists.add(parent);
                }
                //判断是否有第一层元素
                if (parentlists.size() != 0) {
                    for (int i = 0; i < parentlists.size(); i++) {
                        root.addChildren(parentlists.get(i));
                    }
                }
                AndroidTreeView tView = new AndroidTreeView(mContext, root);
                tView.setDefaultContainerStyle(R.style.TreeNodeStyle);
                tView.setUseAutoToggle(true);
                tView.setUse2dScroll(true);
                tView.setDefaultAnimation(true);
                tView.setDefaultNodeClickListener(new TreeNode.TreeNodeClickListener() {
                    @Override
                    public void onClick(TreeNode node, Object value) {
                        listener.SendTreeData((MyHolder.IconTreeItem) value);
                    }
                });
                rlToolShowtree.addView(tView.getView());
            }
    }


