package com.ly.listview_expand;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 具体子adapter 可根据不同的要求自定义
 *
 */
public class DetaiTreeAdapter extends TreeAdapter {

    private LayoutInflater inflater;
    private List<TreeElement> mParentList;

    public DetaiTreeAdapter(List<TreeElement> parentList, Context context) {
        super(parentList, context);
        inflater = LayoutInflater.from(context);
        mParentList = parentList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return super.getCount();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return super.getItem(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return super.getItemId(arg0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        // hodler 需为局部变量
        ViewHodler hodler = new ViewHodler();
        TreeElement treeElement = mParentList.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemview, null);
            hodler.icon =  convertView.findViewById(R.id.ic_img);
            hodler.title =  convertView.findViewById(R.id.title_tv);
            hodler.connection =  convertView
                    .findViewById(R.id.layout_treeview_connection);

            convertView.setTag(hodler);

        } else {
            hodler = (ViewHodler) convertView.getTag();
        }
        // 标题背景设置
        if (treeElement.getParentLevel() == 0) {
            hodler.title.setBackgroundColor(Color.BLUE);
            hodler.title.setPadding(8, 8, 8, 8);
        } else if (treeElement.getParentLevel() == 1) {
            hodler.title.setBackgroundColor(Color.RED);
            hodler.title.setPadding(38, 8, 8, 8);
        } else if (treeElement.getParentLevel() == 2) {
            hodler.title.setPadding(78, 8, 8, 8);
            hodler.title.setBackgroundColor(Color.GRAY);
        }
        hodler.title.setTextColor(Color.WHITE);
        hodler.title.setText(treeElement.getNoteName());

        return convertView;
    }

    @Override
    public void onExpandClick(int position) {
        super.onExpandClick(position);
    }

    class ViewHodler {
        ImageView icon;
        TextView title;
        RelativeLayout connection;
    }
}

