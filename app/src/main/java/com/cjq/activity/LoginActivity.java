package com.cjq.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.cjq.domain.IP;
import com.cjq.utils.IPUtils;
import com.example.administrator.myapp.R;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends Activity implements View.OnClickListener {
    private Button btn_entry;
    private Context context;
    private IP ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        context = this;
        initview();
    }

    private void initview() {
        btn_entry = (Button) findViewById(R.id.btn_login);
        btn_entry.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                Log.e("=====","11111111111");
//                startActivity(new Intent(context, MainActivity.class));
//                finish();
                IPUtils.taobaoIPService.getIp("210.75.225.254", new Callback<IP>() {
                    @Override
                    public void success(IP ip, Response response) {
                        String t = String.valueOf(ip.getCode()) + ip.getData().getIp() + ip.getData().getCountry() + ip.getData().getArea();
                            Toast.makeText(context,t,Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(context,"failue",Toast.LENGTH_SHORT);
                    }
                });
                break;
        }
    }
}
