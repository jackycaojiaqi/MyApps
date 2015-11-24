package com.cjq.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.myapp.R;

/**
 * Created by Administrator on 2015/11/23.
 */
public class RegisterActivity extends Activity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_login);
        initview();
    }

    private void initview() {
        Toast.makeText(context,"1111",Toast.LENGTH_SHORT);
    }
}
