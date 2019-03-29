package com.bawei.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.app.R;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowMyAdapter2 extends RecyclerView.Adapter<ShowMyAdapter2.MyViewHolder> {
       Context context;
       JSONObject mlss;

    public ShowMyAdapter2(Context context, JSONObject mlss) {
        this.context = context;
        this.mlss = mlss;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_show_moli, null, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        try {
            //JSONObject mlss = result.getJSONObject("mlss");
            JSONArray commodityList = mlss.getJSONArray("commodityList");
            JSONObject jsonObject1 = commodityList.getJSONObject(i);
            String commodityName = jsonObject1.getString("commodityName");
            String price = jsonObject1.getString("price");
            String masterPic = jsonObject1.getString("masterPic");
            myViewHolder.name.setText(commodityName);
            myViewHolder.price.setText("¥:"+price+".00");
            Glide.with(context).load(masterPic).into(myViewHolder.img);
         } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mlss.length()-1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.show_pic1);
            name = itemView.findViewById(R.id.show_text_name);
            price = itemView.findViewById(R.id.show_text_price);
        }
    }
}
