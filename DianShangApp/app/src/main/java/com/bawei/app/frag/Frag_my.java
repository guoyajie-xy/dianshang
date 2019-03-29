package com.bawei.app.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.app.R;
import com.bawei.app.activity.LoginActivity;

/**
 * @Auther: 郭亚杰
 * @Date:2019/3/28
 * @Description: 我的页面
 */
public class Frag_my extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_my, container, false);
        //找控件
        //头像
        ImageView my_head = view.findViewById(R.id.my_head_pic1);
        //昵称
        TextView my_name = view.findViewById(R.id.my_name_text);

        //个人资料
        ImageView my_information = view.findViewById(R.id.my_information);
        //我的圈子
        ImageView my_circle = view.findViewById(R.id.my_circle);
        //我的足迹
        ImageView my_foot = view.findViewById(R.id.my_foot);
        //我的钱包
        ImageView my_wallet = view.findViewById(R.id.my_wallet);
        //我的收货地址
        ImageView my_address = view.findViewById(R.id.my_address);


        my_head.setOnClickListener(this);
        my_name.setOnClickListener(this);

        my_information.setOnClickListener(this);
        my_circle.setOnClickListener(this);
        my_foot.setOnClickListener(this);
        my_wallet.setOnClickListener(this);
        my_address.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_head_pic1:

                break;
            case R.id.my_name_text:
              //点击登录
                startActivity(new Intent(getActivity(),LoginActivity.class));
                getActivity().finish();
                break;
            case R.id.my_information:

                break;
            case R.id.my_circle:

                break;
            case R.id.my_foot:

                break;
            case R.id.my_wallet:

                break;
            case R.id.my_address:

                break;
        }
    }
}
