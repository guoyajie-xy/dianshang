package com.bawei.app.presenter;

import com.bawei.app.activity.LoginActivity;
import com.bawei.app.model.LoginModel;
import com.bawei.app.view.LoginView;

public class LoginPresenter {

    private final LoginModel loginModel;
    private final LoginView loginView;

    public LoginPresenter(LoginView view) {
        loginModel = new LoginModel();
        loginView = view;
    }

    public void sendPareter(String phoneText, String passText) {
      loginModel.login(phoneText,passText);
      loginModel.OnLoginLisenter(new LoginModel.OnLoginLisenter() {
          @Override
          public void onResult(String status) {
              loginView.view(status);
          }
      });
    }
}
