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
import org.json.JSONObject;

public class ShowMyAdapter3 extends RecyclerView.Adapter<ShowMyAdapter3.MyViewHolder> {
       Context context;
       JSONObject result;

    public ShowMyAdapter3(Context context, JSONObject result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_show, null, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        try {
            JSONObject pzsh = result.getJSONObject("pzsh");
            JSONArray commodityList = pzsh.getJSONArray("commodityList");
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
        return result.length()+1;
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
