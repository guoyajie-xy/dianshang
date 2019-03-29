package com.bawei.app.custom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.app.R;
import com.stx.xhb.xbanner.XBanner;

public class CustomView extends LinearLayout {


    private RecyclerView rc;
    private EditText ed_tex;
    private Button search;
   private interface OnSearchGoods{
       void search(String tex);
   }
   public OnSearchGoods onSearchGoods;

    public void setOnSearchGoods(OnSearchGoods onSearchGoods) {
        this.onSearchGoods = onSearchGoods;
    }

    public CustomView(Context context) {
        super(context);
    }
    public CustomView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_layout,this);
        rc = findViewById(R.id.rc);
        ed_tex = findViewById(R.id.ed_tex);
        search = findViewById(R.id.search);

        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = ed_tex.getText().toString().trim();
                if (s.isEmpty()){
                    Toast.makeText(context, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                     return;
                }else {
                    onSearchGoods.search(s);
                }
            }
        });
    }

    public CustomView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
