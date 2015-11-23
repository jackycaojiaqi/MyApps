package com.cjq.activity;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cjq.adapter.MyFragmentPagerAdapter;
import com.cjq.fragment.ContactsFragment;
import com.cjq.fragment.MessageFragment;
import com.cjq.fragment.NewsFragment;
import com.cjq.fragment.SettingFragment;
import com.example.administrator.myapp.R;

import java.util.ArrayList;

/**
 * 参考原作者D.Winter基础，
 *
 * @author avenwu
 *         iamavenwu@gmail.com
 */
public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private TextView tvTabActivity, tvTabGroups, tvTabFriends, tvTabChat;
    private ImageView iv_main_chat, iv_main_msg, iv_main_find, iv_main_setting;
    private LinearLayout lly_chat, lly_msg, lly_find, lly_setting;
    private int currIndex = 0;
    private Resources resources;
    private  String a ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        resources = getResources();
        InitTextView();
        InitViewPager();
    }

    private void InitTextView() {
        iv_main_chat = (ImageView) findViewById(R.id.iv_main_talk);
        iv_main_msg = (ImageView) findViewById(R.id.iv_main_msg);
        iv_main_find = (ImageView) findViewById(R.id.iv_main_find);
        iv_main_setting = (ImageView) findViewById(R.id.iv_main_setting);


        lly_chat = (LinearLayout) findViewById(R.id.lly_chat);
        lly_msg = (LinearLayout) findViewById(R.id.lly_msg);
        lly_find = (LinearLayout) findViewById(R.id.lly_find);
        lly_setting = (LinearLayout) findViewById(R.id.lly_setting);

        lly_chat.setOnClickListener(new MyOnClickListener(0));
        lly_msg.setOnClickListener(new MyOnClickListener(1));
        lly_find.setOnClickListener(new MyOnClickListener(2));
        lly_setting.setOnClickListener(new MyOnClickListener(3));
    }

    private void InitViewPager() {
        mPager = (ViewPager) findViewById(R.id.vPager);
        fragmentsList = new ArrayList<Fragment>();
        Fragment activityfragment = ContactsFragment.newInstance("Hello Activity.");
        Fragment groupFragment = MessageFragment.newInstance("Hello Group.");
        Fragment friendsFragment = NewsFragment.newInstance("Hello Friends.");
        Fragment chatFragment = SettingFragment.newInstance("Hello Chat.");

        fragmentsList.add(activityfragment);
        fragmentsList.add(groupFragment);
        fragmentsList.add(friendsFragment);
        fragmentsList.add(chatFragment);

        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentsList));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }


    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    }

    ;

    public class MyOnPageChangeListener implements OnPageChangeListener {

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    iv_main_chat.setBackground(getResources().getDrawable(R.drawable.ic_tab_more_sel));
                    iv_main_msg.setBackground(getResources().getDrawable(R.drawable.ic_tab_msg_nor));
                    iv_main_find.setBackground(getResources().getDrawable(R.drawable.ic_tab_parent_nor));
                    iv_main_setting.setBackground(getResources().getDrawable(R.drawable.ic_tab_qbb6_nor));

                    break;
                case 1:
                    iv_main_chat.setBackground(getResources().getDrawable(R.drawable.ic_tab_more_nor));
                    iv_main_msg.setBackground(getResources().getDrawable(R.drawable.ic_tab_msg_sel));
                    iv_main_find.setBackground(getResources().getDrawable(R.drawable.ic_tab_parent_nor));
                    iv_main_setting.setBackground(getResources().getDrawable(R.drawable.ic_tab_qbb6_nor));
                    break;
                case 2:
                    iv_main_chat.setBackground(getResources().getDrawable(R.drawable.ic_tab_more_nor));
                    iv_main_msg.setBackground(getResources().getDrawable(R.drawable.ic_tab_msg_nor));
                    iv_main_find.setBackground(getResources().getDrawable(R.drawable.ic_tab_parent_sel));
                    iv_main_setting.setBackground(getResources().getDrawable(R.drawable.ic_tab_qbb6_nor));
                    break;
                case 3:
                    iv_main_chat.setBackground(getResources().getDrawable(R.drawable.ic_tab_more_nor));
                    iv_main_msg.setBackground(getResources().getDrawable(R.drawable.ic_tab_msg_nor));
                    iv_main_find.setBackground(getResources().getDrawable(R.drawable.ic_tab_parent_nor));
                    iv_main_setting.setBackground(getResources().getDrawable(R.drawable.ic_tab_qbb6_sel));
                    break;
            }
            currIndex = arg0;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
}