package com.ly.listview_expand;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView mLv;
    private DetaiTreeAdapter adapter;
    private ArrayList<TreeElement> dataList;
    private ArrayList<TreeElement> seconddataList;
    private ArrayList<TreeElement> thirddataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    /**
     * 事件处理
     */
    private void initEvent() {
        mLv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                adapter.onExpandClick(arg2);
            }
        });
    }

    /**
     * 数据加载
     */
    private void initData() {
        dataList = new ArrayList<>();
        seconddataList = new ArrayList<>();
        thirddataList = new ArrayList<>();
        adapter = new DetaiTreeAdapter(dataList, MainActivity.this);
        mLv.setAdapter(adapter);
        //模拟三级节点数据
        for (int i = Data.thridTitle.length - 1; i >= 0; i--) {
            TreeElement element = new TreeElement(2, Data.thridTitle[i], new ArrayList<TreeElement>(),
                    false, false, i);
            thirddataList.add(element);
        }
        //模拟二级节点数据
        for (int i = Data.secondTitle.length - 1; i >= 0; i--) {
            TreeElement element = new TreeElement(1, Data.secondTitle[i],
                    i == 0 ? thirddataList : null, false,
                    i == 0, i);
            seconddataList.add(element);
        }
        //模拟一级节点数据
        for (int i = 0; i < Data.title.length; i++) {
            TreeElement element = new TreeElement(0, Data.title[i],

                    i == 0 ? seconddataList : null, false, i == 0, i);
            dataList.add(element);
        }
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        mLv = findViewById(R.id.list);
    }
}

