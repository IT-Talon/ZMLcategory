package com.talon.zmlcategory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mViewPager;
    private List<CategoryFragment> pageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDate();
    }

    private void initDate() {
        pageList = new ArrayList<>();
        pageList.add(new CategoryFragment());
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return pageList.get(position);
            }

            @Override
            public int getCount() {
                return pageList.size();
            }
        });
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_main);
    }

    @Override
    public void onClick(View v) {
        String str = "";
        switch (v.getId()) {
            case R.id.rb_jiaju:
                str = "jiaju";
                break;
            case R.id.rb_xuexi:
                str = "xuexi";
                break;
            case R.id.rb_chufang:
                str = "chufang";
                break;
            case R.id.rb_common:
                str = "cangyong";
                break;
            case R.id.rb_jijian:
                str = "jijian";
                break;
            case R.id.rb_zonghe:
                str = "zonghe";
                break;
            case R.id.rb_jiushui:
                str = "jiushui";
                break;
        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
