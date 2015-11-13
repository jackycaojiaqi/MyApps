package com.cjq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.administrator.myapp.R;

public class LoginActivity extends Activity implements View.OnClickListener {
    private ImageView iv_logo;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        context = this;
        initview();
    }

    private void initview() {
        iv_logo = (ImageView) findViewById(R.id.iv_logo);
        iv_logo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_logo:
               startActivity(new Intent(context,MainActivity.class));
                finish();
                break;
        }
    }
}
