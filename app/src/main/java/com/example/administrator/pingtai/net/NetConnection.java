package com.example.administrator.pingtai.net;

import android.os.AsyncTask;
import android.util.Log;

import com.example.administrator.pingtai.data.PingTai_Config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/4/16.
 */

public class NetConnection {

    public NetConnection(final String url, final HttpMethod method, final SuccessCallback successCallback, final FailCallback failCallback, final String... kvs){

        new AsyncTask<Void,Void,String>() {
            @Override
            protected String doInBackground(Void... params) {

                StringBuffer paramsStr = new StringBuffer();
                for (int i = 0; i < kvs.length; i+=2) {
                    paramsStr.append(kvs[i]).append("=").append(kvs[i+1]).append("&");
                }

                try {
                    URLConnection urlConnection = new URL(url).openConnection();

                    switch (method){
                        case POST:
                            urlConnection.setDoOutput(true);
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(),PingTai_Config.CHARSET));
                            bw.write(paramsStr.toString());
                            bw.flush();
                            bw.close();
                            break;
                        default:
                             urlConnection = new URL(url+"?"+paramsStr.toString()).openConnection();
                            break;
                    }

                    System.out.println("Request url:"+urlConnection.getURL());
                    System.out.println("Request data:" + paramsStr);

                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),PingTai_Config.CHARSET));
                    String line = null;
                    StringBuffer result = new StringBuffer();
                    while((line = br.readLine())!=null){
                        result.append(line);
                    }
                    System.out.println("Result:" + result);
                    Log.i("Request",result.toString());
                    br.close();
                    return result.toString();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {

                if(result != null){
                    if(successCallback!=null){
                        successCallback.onSuccess(result);
                    }
                }else {
                    failCallback.onFail();
                }

                super.onPostExecute(result);
            }
        }.execute();
    }

    public  static  interface SuccessCallback{
        void onSuccess(String result);
    }

    public static interface FailCallback{
        void onFail();
    }
}
