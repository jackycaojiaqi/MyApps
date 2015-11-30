package com.cjq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.cjq.domain.Constant;
import com.cjq.domain.IP;
import com.example.administrator.library.CircleProgress;
import com.example.administrator.myapp.R;

import tyrantgit.explosionfield.ExplosionField;

public class LoginActivity extends Activity implements View.OnClickListener {
    private Button btn_entry, btn_register;
    private Context context;
    private IP ip;
    private ExplosionField mExplosionField;
    private boolean isfirst = true;
    private CircleProgress mProgressView;
    private static int MSG_SEND_INFO_CIRCLE = 0X0001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        context = this;
        mExplosionField = ExplosionField.attach2Window(this);
        initview();
    }

    private void initview() {
        btn_entry = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_entry.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        mProgressView = (CircleProgress) findViewById(R.id.progress);
        mProgressView.setDuration(5400);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
            case R.id.btn_login:
                mExplosionField.explode(v);
                mProgressView.reset();
                mProgressView.setVisibility(View.VISIBLE);
                mProgressView.startAnim();
                mhandle.sendEmptyMessageDelayed(Constant.MSG_SEND_INFO, 1000);
                mhandle.sendEmptyMessageDelayed(Constant.MSG_SEND_INFO_CIRCLE, 8000);
                break;
        }
    }

    private void reset(View view) {
        view.setScaleX(1);
        view.setScaleY(1);
        view.setAlpha(1);
    }

    private android.os.Handler mhandle = new android.os.Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.MSG_SEND_INFO:
                    reset(btn_entry);
                    reset(btn_register);
                    startActivity(new Intent(context, MainActivity.class));
                    finish();
                    break;
                case Constant.MSG_SEND_INFO_CIRCLE:
                    mProgressView.stopAnim();
                    mProgressView.setVisibility(View.INVISIBLE);
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mhandle.removeCallbacksAndMessages(null);
    }

}
