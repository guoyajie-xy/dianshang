package com.bawei.app.presenter;

import com.bawei.app.frag.Frag_home;
import com.bawei.app.model.ShowHomeModel;
import com.bawei.app.view.ShowHomeView;

import org.json.JSONObject;

public class ShowHomePresenter {

    private final ShowHomeModel showHomeModel;
    private final ShowHomeView showHomeView;

    public ShowHomePresenter(ShowHomeView view) {
        showHomeModel = new ShowHomeModel();
        showHomeView = view;
    }

    public void sendShows() {
        showHomeModel.show();
        showHomeModel.OnShowListenter(new ShowHomeModel.OnShowListenter() {
            @Override
            public void onShow(JSONObject result) {
                showHomeView.view(result);
            }
        });
    }
}
