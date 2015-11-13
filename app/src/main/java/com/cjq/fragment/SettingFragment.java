package com.cjq.fragment;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.example.administrator.myapp.R;


public class SettingFragment extends Fragment implements OnClickListener {
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_welcome, container, false);
        context = getActivity();
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    public static SettingFragment newInstance(String s) {
        SettingFragment newFragment = new SettingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("hello", s);
        newFragment.setArguments(bundle);
        return newFragment;

    }
}
