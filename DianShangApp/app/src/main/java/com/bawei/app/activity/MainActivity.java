package com.bawei.app.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.app.R;
import com.bawei.app.frag.Frag_car;
import com.bawei.app.frag.Frag_circle;
import com.bawei.app.frag.Frag_home;
import com.bawei.app.frag.Frag_list;
import com.bawei.app.frag.Frag_my;
/**
 * @Auther: 郭亚杰
 * @Date:2019/3/29
 * @Description: 根基主页面
 */
public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Frag_home frag_home;
    private Frag_circle frag_circle;
    private Frag_car frag_car;
    private Frag_list frag_list;
    private Frag_my frag_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        RadioGroup radioGroup = findViewById(R.id.radioGroup1);
        //获取管理者
        manager = getSupportFragmentManager();
        //开启事务
        transaction = manager.beginTransaction();
        //碎片
        frag_home = new Frag_home();
        //提交事务
        transaction.add(R.id.home_frame, frag_home).commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //一定要加
                hideFrag();
                //开启事务
                transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.radio1:
                        transaction.show(frag_home).commit();
                        break;
                    case R.id.radio2:
                        if (frag_circle == null) {
                            frag_circle = new Frag_circle();
                            transaction.add(R.id.home_frame, frag_circle).commit();
                        } else {

                            transaction.show(frag_circle).commit();
                        }
                        break;
                    case R.id.radio3:
                        if (frag_car == null) {
                            frag_car = new Frag_car();
                            transaction.add(R.id.home_frame, frag_car).commit();
                        } else {

                            transaction.show(frag_car).commit();
                        }
                        break;
                    case R.id.radio4:
                        if (frag_list == null) {
                            frag_list = new Frag_list();
                            transaction.add(R.id.home_frame, frag_list).commit();
                        } else {

                            transaction.show(frag_list).commit();
                        }
                        break;
                    case R.id.radio5:
                        if (frag_my == null) {
                            frag_my = new Frag_my();
                            transaction.add(R.id.home_frame, frag_my).commit();
                        } else {

                            transaction.show(frag_my).commit();
                        }
                        break;

                }
            }
        });
    }

    //隐藏事件
    private void hideFrag() {
        //开启事务
        transaction = manager.beginTransaction();
        //不等于空或者是否添加的时候
        if (frag_home != null && frag_home.isAdded()) {
            transaction.hide(frag_home);

        }
        if (frag_circle != null && frag_circle.isAdded()) {
            transaction.hide(frag_circle);

        }
        if (frag_car != null && frag_car.isAdded()) {
            transaction.hide(frag_car);

        }
        if (frag_list != null && frag_list.isAdded()) {
            transaction.hide(frag_list);

        }
        if (frag_my != null && frag_my.isAdded()) {
            transaction.hide(frag_my);

        }
        transaction.commit();
    }
}
