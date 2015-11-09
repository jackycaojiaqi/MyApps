package com.cjq.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.administrator.myapp.R;

/**
 * Created by Administrator on 2015/11/9.
 */
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
    }
}
