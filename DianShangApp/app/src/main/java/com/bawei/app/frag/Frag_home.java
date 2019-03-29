package com.bawei.app.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.app.R;
import com.bawei.app.adapter.ShowMyAdapter;
import com.bawei.app.adapter.ShowMyAdapter2;
import com.bawei.app.adapter.ShowMyAdapter3;
import com.bawei.app.presenter.ShowHomePresenter;
import com.bawei.app.view.ShowHomeView;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
/**
 * @Auther: 郭亚杰
 * @Date:2019/3/21
 * @Description: 首页展示
 */
public class Frag_home extends Fragment implements ShowHomeView {

    private View view;
    private XBanner banner;
    private ArrayList<String> images;
    private ArrayList<String> titles;
    private RecyclerView rc1;
    private GridLayoutManager manager;
    private ShowHomePresenter presenter;
    private RecyclerView rc2;
    private LinearLayoutManager manager1;
    private ShowMyAdapter2 showMyAdapter2;
    private JSONObject mlss;
    private RecyclerView rc3;
    private GridLayoutManager manager2;
    private ShowMyAdapter3 showMyAdapter3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_home, container, false);
        banner = view.findViewById(R.id.banner1);
        //初始化XBanner中展示数据
        images = new ArrayList<>();
        titles = new ArrayList<>();

        images.add("http://172.17.8.100/images/small/banner/cj.png");
        images.add("http://172.17.8.100/images/small/banner/hzp.png");
        images.add("http://172.17.8.100/images/small/banner/lyq.png");
        images.add("http://172.17.8.100/images/small/banner/px.png");
        images.add("http://172.17.8.100/images/small/banner/wy.png");

        banner.setData(images, null);
        //XBanner适配数据
        banner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(images.get(position)).into((ImageView) view);
            }
        });
        // 设置XBanner的页面切换特效
        banner.setPageTransformer(Transformer.Default);
        // 设置XBanner页面切换的时间，即动画时长
        banner.setPageChangeDuration(1000);
        //----------------------------------------------------
        //找控件 热销新品
        rc1 = view.findViewById(R.id.rce1);
        //创建布局管理器
        manager = new GridLayoutManager(getActivity(), 3);
       //设置布局管理器
        rc1.setLayoutManager(manager);

        //找控件 魔力时尚
        rc2 = view.findViewById(R.id.rce2);
        manager1 = new LinearLayoutManager(getActivity());
        rc2.setLayoutManager(manager1);
        //找控件 品质生活
        rc3 = view.findViewById(R.id.rce3);
        manager2 = new GridLayoutManager(getActivity(), 2);
        rc3.setLayoutManager(manager2);
       //实例化presenter
        presenter = new ShowHomePresenter(this);
        //传参
        presenter.sendShows();


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void view(JSONObject result) {
        try {
            mlss = result.getJSONObject("mlss");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //热销产品
        ShowMyAdapter showMyAdapter = new ShowMyAdapter(getActivity(), result);
        rc1.setAdapter(showMyAdapter);
        //魔力时尚
        showMyAdapter2 = new ShowMyAdapter2(getActivity(), mlss);
        rc2.setAdapter(showMyAdapter2);
        //品质生活
        showMyAdapter3 = new ShowMyAdapter3(getActivity(), result);
        rc3.setAdapter(showMyAdapter3);
    }
}
