package com.bawei.app.utils;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpsUitls {
    private  static OkHttpsUitls okHttpsUitls=null;

    private static OkHttpsUitls okHttpsUitls1;

    private OkHttpsUitls(){

    }
    public static OkHttpsUitls getInstance(){
        if (okHttpsUitls==null)
        {
            synchronized (OkHttpsUitls.class){
                if (okHttpsUitls==null){
                    okHttpsUitls1 = new OkHttpsUitls();

                }
            }
        }

        return okHttpsUitls;
    }
    public static void doGet(String url, Callback callback){

        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx",message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        Request request=new Request.Builder().url(url).
                build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

}
