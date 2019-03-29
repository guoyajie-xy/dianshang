package com.bawei.app.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bawei.app.utils.OkHttpsUitls;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShowHomeModel {
    private String url = "http://172.17.8.100/small/commodity/v1/commodityList";

    public interface OnShowListenter {
        void onShow(JSONObject result);
    }

    public OnShowListenter showListenter;

    public void OnShowListenter(OnShowListenter showListenter) {
        this.showListenter = showListenter;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String path= (String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(path);
                        JSONObject result = jsonObject.getJSONObject("result");
                        if (showListenter!=null){
                            showListenter.onShow(result);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };

    public void show() {
        OkHttpsUitls.getInstance().doGet(url,new Callback() {
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
