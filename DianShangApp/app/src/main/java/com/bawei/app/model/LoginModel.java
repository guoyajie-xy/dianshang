package com.bawei.app.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginModel {

    public interface  OnLoginLisenter{
        void onResult(String status);
    }

    public  OnLoginLisenter loginLisenter;

    public void OnLoginLisenter(OnLoginLisenter loginLisenter){
        this.loginLisenter=loginLisenter;

    }
     private Handler handler=  new Handler(){
         @Override
         public void handleMessage(Message msg) {
             super.handleMessage(msg);
             switch (msg.what){
                 case 0:
                     String path= (String) msg.obj;
                     try {
                         JSONObject jsonObject=new JSONObject(path);
                         String status = jsonObject.getString("status");

                         if (loginLisenter!=null){
                             loginLisenter.onResult(status);
                         }
                     } catch (Exception e) {
                         e.printStackTrace();
                     }

                     break;
             }
         }
     };
    private String url="http://172.17.8.100/small/user/v1/login";
    public void login(String phoneText, String passText) {
        OkHttpClient okHttpClient=new OkHttpClient();

        RequestBody requestBody=new FormBody.Builder().
                add("phone",phoneText).
                add("pwd",passText).
                build();
        Request request=new Request.Builder().url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("xxx",string);
                Message message = new Message();
                message.what=0;
                message.obj=string;
                handler.sendMessage(message);
            }
        });
    }
}
