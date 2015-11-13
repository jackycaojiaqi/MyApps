package com.cjq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;

import com.cjq.domain.Constant;
import com.example.administrator.myapp.R;


/**
 * Created by Administrator on 2015/11/9.
 */
public class WelcomeActivity extends Activity {
    private Context context;
    private  String TAG = "WelcomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        context = this;
        setContentView(R.layout.activity_welcome);
        t.start();
    }

    Handler mhandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.MSG_SEND_INFO:
                    Log.e(TAG,"=========handle");
                    startActivity(new Intent(context, LoginActivity.class));
                    finish();
                    break;
            }
            super.handleMessage(msg);
        }
    };
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            Log.e(TAG, "=========RUN");
            mhandle.sendEmptyMessageDelayed(Constant.MSG_SEND_INFO, 3000);
        }
    });
}
