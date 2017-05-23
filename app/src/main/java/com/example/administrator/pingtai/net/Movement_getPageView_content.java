package com.example.administrator.pingtai.net;

import com.example.administrator.pingtai.data.PingTai_Config;

/**
 * Created by Administrator on 2017/5/21.
 */

public class Movement_getPageView_content {
    public Movement_getPageView_content(){
        new NetConnection(PingTai_Config.SERVER_URL, HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {

            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail() {

            }
        },PingTai_Config.KEY_ACTION,PingTai_Config.ACTION_GETPAGEVIEWCONTENT);
    }
}
