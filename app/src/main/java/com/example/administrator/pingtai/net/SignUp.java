package com.example.administrator.pingtai.net;

import com.example.administrator.pingtai.data.PingTai_Config;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/5/20.
 */

public class SignUp {
    public SignUp(String code, String phoneNum, final SuccessCallback successCallback, final FailCallback failCallback){
        new NetConnection(PingTai_Config.SERVER_URL+"signup", HttpMethod.POST,new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);

                    switch (jsonObject.getInt(PingTai_Config.KEY_STATUS)){
                        case PingTai_Config.RESULT_STATUS_SUCCESS:
                            if(successCallback!=null){
                                successCallback.onSuccess();
                            }
                            break;
                        default:
                            if(failCallback!=null){
                                failCallback.onFail();
                            }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if(failCallback!=null){
                        failCallback.onFail();
                    }
                }
            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail() {

            }
        }, PingTai_Config.KEY_ACTION,PingTai_Config.ACTION_SIGNUP,
                PingTai_Config.KEY_PHONE_NUM,phoneNum,
                PingTai_Config.KEY_CODE,code);
    }

    public static interface SuccessCallback{
        void onSuccess();
    }

    public static interface FailCallback{
        void onFail();
    }
}
