package com.example.administrator.pingtai.net;

import com.example.administrator.pingtai.data.PingTai_Config;

import org.json.JSONException;
import org.json.JSONObject;

public class Movement {

    public Movement(String Phone_MD5, String token, int page, int perpage, final SuccessCallback successCallback,final FailCallback failCallback){
        new NetConnection(PingTai_Config.SERVER_URL,HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject result_json = new JSONObject(result);

                    switch (result_json.getInt(PingTai_Config.KEY_STATUS)){
                        case PingTai_Config.RESULT_STATUS_SUCCESS:

                            break;
                        default:
                            if (failCallback!=null){
                                failCallback.onFail();
                            }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (failCallback != null) {
                        failCallback.onFail();

                    }
                }
            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail() {
                failCallback.onFail();
            }
        },PingTai_Config.KEY_ACTION
                ,PingTai_Config.ACTION_MOVEMENT
                ,PingTai_Config.KEY_PHONE_MD5,Phone_MD5
                ,PingTai_Config.KEY_TOKEN,token
                ,PingTai_Config.KEY_PAGE,page+""
                ,PingTai_Config.KEY_PERPAGE,perpage+"");

    }

    public static interface SuccessCallback{
        void onSuccess(String token);
    }

    public static interface FailCallback{
        void onFail();
    }
}
