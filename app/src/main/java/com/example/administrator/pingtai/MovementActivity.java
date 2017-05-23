package com.example.administrator.pingtai;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.administrator.pingtai.data.PingTai_Config;
import com.example.administrator.pingtai.net.HttpMethod;
import com.example.administrator.pingtai.net.NetConnection;

import java.util.ArrayList;

import cn.lightsky.infiniteindicator.InfiniteIndicator;
import cn.lightsky.infiniteindicator.OnPageClickListener;
import cn.lightsky.infiniteindicator.Page;

/**
 * Created by Administrator on 2017/4/16.
 */

public class MovementActivity extends FragmentActivity implements ViewPager.OnPageChangeListener, OnPageClickListener {

    private ArrayList<Page> pageViews;
    private InfiniteIndicator myCircleIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movement);

        String page = "1";
        String perpage = "5";

        new NetConnection(PingTai_Config.SERVER_URL, HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {

            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail() {

            }
        },PingTai_Config.KEY_ACTION,PingTai_Config.ACTION_MOVEMENT,
                PingTai_Config.KEY_PAGE,page,
                PingTai_Config.KEY_PERPAGE,perpage);

        initData();
//        testAnimCircleIndicator();
    }

    private void initData() {
        pageViews = new ArrayList<>();

//        ArrayAdapter pageAdapter = new ArrayAdapter(MovementActivity.this,);
    }

    //To avoid memory leak ,you should release the res
    @Override
    protected void onPause() {
        super.onPause();
        myCircleIndicator.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        myCircleIndicator.start();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageClick(int position, Page page) {

    }
}