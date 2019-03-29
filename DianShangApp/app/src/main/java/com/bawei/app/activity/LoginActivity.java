package com.bawei.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.app.R;
import com.bawei.app.presenter.LoginPresenter;
import com.bawei.app.utils.Utils;
import com.bawei.app.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText phone;
    private EditText pass;
    private Button login;
    private TextView register;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //找控件
        //手机号
        phone = findViewById(R.id.edit_phone);
        //登录密码
        pass = findViewById(R.id.edit_pass);
        //登录
        login = findViewById(R.id.login1);
        //注册
        register = findViewById(R.id.register1);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        //关联presenter
        presenter = new LoginPresenter(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login1:
                //获取输入框的值
                String phoneText = phone.getText().toString().trim();
                String passText = pass.getText().toString().trim();
                boolean mobileNO = Utils.isMobileNO(phoneText);
                //进行手机号校验
                if (!mobileNO) {
                    Toast.makeText(this, "手机号码格式不正确！！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passText.length() < 3) {
                    Toast.makeText(this, "密码长度不能小于3", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.sendPareter(phoneText,passText);
                break;
            case R.id.register1:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void view(String status) {
       if (status.equals("0000")){
          startActivity(new Intent(LoginActivity.this,MainActivity.class));
       }
    }
}
