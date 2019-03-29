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

/**
 * @Auther: 郭亚杰
 * @Date:2019/3/29
 * @Description: 注册页面
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private TextView login;
    private EditText phone;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //找控件
        phone = findViewById(R.id.edit_phone);
        pass = findViewById(R.id.edit_pass);
        //注册
        register = findViewById(R.id.register2);
        //立即登录登录
        login = findViewById(R.id.login2);
        register.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //注册
            case R.id.register2:
                String phoneText = phone.getText().toString().trim();
                String passText = pass.getText().toString().trim();
                if (phoneText.equals("") && passText.equals("")) {
                    Toast.makeText(this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                break;
            //立即登录登录
            case R.id.login2:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
        }
    }
}
