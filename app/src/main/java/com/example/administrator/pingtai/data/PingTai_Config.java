package com.example.administrator.pingtai.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/4/16.
 */

public class PingTai_Config {

    public static final String SERVER_URL = "http://211.96.19.60/gadilan/Home/User/";
    public static final String APP_ID="com.example.administrator.pingtai";
    public static final String CHARSET = "UTF-8";

    public static final String KEY_TOKEN = "token";
    public static final String KEY_ACTION = "action";
    public static final String KEY_PHONE_NUM = "phoneNum";
    public static final String KEY_PHONE_MD5 = "phoneMd5";
    public static final String KEY_STATUS = "status";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_PAGE = "page";
    public static final String KEY_PERPAGE = "perpage";
    public static final String KEY_CODE = "code";
    public static final String KEY_REALNAME = "realname";
    public static final String KEY_STUDNUM = "studnum";
    public static final String KEY_CITY = "city";
    public static final String KEY_HEADPORTRAIT = "headportrait";

    public static final String ACTION_GET_CODE = "get_code";
    public static final String ACTION_LOGIN = "log_in";
    public static final String ACTION_MOVEMENT = "movement";
    public static final String ACTION_GETPAGEVIEWCONTENT = "getPageViewContent";
    public static final String ACTION_SIGNUP = "signup";
    public static final String ACTION_UPLOADINFO = "uploadinfo";

    public static final int RESULT_STATUS_SUCCESS = 1;
    public static final int RESULT_STATUS_FAIL = 0;
    public static final int RESULT_STATUS_INVALID_TOKEN = 2;


    public static String getCachedToken(Context context){
        return context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).getString(KEY_TOKEN,null);
    }

    public static void cachToken(Context context,String token){
        SharedPreferences.Editor editor = context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).edit();
        editor.putString(KEY_TOKEN,token);
        editor.commit();
    }

    public static String getCachedPhoneNum(Context context){
        return context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).getString(KEY_PHONE_NUM,null);
    }

    public static void cachPhoneNum(Context context,String PhoneNum){
        SharedPreferences.Editor editor = context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).edit();
        editor.putString(KEY_PHONE_NUM,PhoneNum);
        editor.commit();
    }
}
