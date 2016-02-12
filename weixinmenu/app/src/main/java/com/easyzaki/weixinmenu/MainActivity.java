package com.easyzaki.weixinmenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private SparseArray<Fragment> mFragments;
    private ViewPager mVp_content;
    private RadioGroup mRg_index_tab;
    private RadioButton mRb_tab1;
    private RadioButton mRb_tab2;
    private RadioButton mRb_tab3;
    private RadioButton mRb_tab4;
    private ImageView mIv_tab1;
    private ImageView mIv_tab2;
    private ImageView mIv_tab3;
    private ImageView mIv_tab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        addListener();
        initData();
    }

    private void addListener() {
        mRg_index_tab.setOnCheckedChangeListener(this);
        mVp_content.addOnPageChangeListener(this);
    }

    private void initData() {
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mVp_content = (ViewPager) findViewById(R.id.vp_content);
        mRg_index_tab = (RadioGroup) findViewById(R.id.rg_index_tab);
        mRb_tab1 = (RadioButton) findViewById(R.id.rb_tab1);
        mRb_tab2 = (RadioButton) findViewById(R.id.rb_tab2);
        mRb_tab3 = (RadioButton) findViewById(R.id.rb_tab3);
        mRb_tab4 = (RadioButton) findViewById(R.id.rb_tab4);
        mIv_tab1 = (ImageView) findViewById(R.id.iv_tab1);
        mIv_tab2 = (ImageView) findViewById(R.id.iv_tab2);
        mIv_tab3 = (ImageView) findViewById(R.id.iv_tab3);
        mIv_tab4 = (ImageView) findViewById(R.id.iv_tab4);
        mFragments = new SparseArray<Fragment>();
        addFragments();
        mVp_content.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
        mVp_content.setCurrentItem(0, false);
    }

    private void addFragments() {
        mFragments = new SparseArray<>();
        mFragments.put(0, Fragment.instantiate(getApplicationContext(), Tab1Fragment.class.getName()));
        mFragments.put(1, Fragment.instantiate(getApplicationContext(), Tab2Fragment.class.getName()));
        mFragments.put(2, Fragment.instantiate(getApplicationContext(), Tab3Fragment.class.getName()));
        mFragments.put(3, Fragment.instantiate(getApplicationContext(), Tab4Fragment.class.getName()));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_tab1:
                mVp_content.setCurrentItem(0, false);
                break;
            case R.id.rb_tab2:
                mVp_content.setCurrentItem(1, false);
                break;
            case R.id.rb_tab3:
                mVp_content.setCurrentItem(2, false);
                break;
            case R.id.rb_tab4:
                mVp_content.setCurrentItem(3, false);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("aaaaa", position + "");
        switch (position) {
            case 0:
                mIv_tab2.setVisibility(View.VISIBLE);
                mIv_tab1.setVisibility(View.VISIBLE);
                mIv_tab2.setAlpha(positionOffset);
                mIv_tab1.setAlpha(1 - positionOffset);
                mIv_tab3.setVisibility(View.INVISIBLE);
                mIv_tab4.setVisibility(View.INVISIBLE);
                break;
            case 1:
                mIv_tab3.setVisibility(View.VISIBLE);
                mIv_tab2.setVisibility(View.VISIBLE);
                mIv_tab3.setAlpha(positionOffset);
                mIv_tab2.setAlpha(1 - positionOffset);
                mIv_tab1.setVisibility(View.INVISIBLE);
                mIv_tab4.setVisibility(View.INVISIBLE);
                break;
            case 2:
                mIv_tab4.setVisibility(View.VISIBLE);
                mIv_tab3.setVisibility(View.VISIBLE);
                mIv_tab4.setAlpha(positionOffset);
                mIv_tab3.setAlpha(1 - positionOffset);
                mIv_tab1.setVisibility(View.INVISIBLE);
                mIv_tab2.setVisibility(View.INVISIBLE);
                break;
            case 3:
                mIv_tab1.setVisibility(View.INVISIBLE);
                mIv_tab2.setVisibility(View.INVISIBLE);
                mIv_tab3.setVisibility(View.INVISIBLE);
                mIv_tab4.setVisibility(View.VISIBLE);
                mIv_tab4.setAlpha(1.0f);
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
