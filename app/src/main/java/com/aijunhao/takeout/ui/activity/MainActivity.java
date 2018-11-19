package com.aijunhao.takeout.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aijunhao.takeout.R;
import com.aijunhao.takeout.ui.fragment.HomeFragment;
import com.aijunhao.takeout.ui.fragment.MineFragment;
import com.aijunhao.takeout.ui.fragment.MoreFragment;
import com.aijunhao.takeout.ui.fragment.OrderFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;

    private ArrayList<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takeout_activity_main);
        ButterKnife.bind(this);

        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new MoreFragment());
        list.add(new OrderFragment());
        list.add(new MineFragment());

        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        bottomBar.setOnTabSelectListener(new MyOnTabSelectListener());
    }

    private class MyOnTabSelectListener implements OnTabSelectListener {
        @Override
        public void onTabSelected(int tabId) {
            switch (tabId) {
                case R.id.tab_home:
                    viewPager.setCurrentItem(0, false);
                    break;
                case R.id.tab_more:
                    viewPager.setCurrentItem(1, false);
                    break;
                case R.id.tab_order:
                    viewPager.setCurrentItem(2, false);
                    break;
                case R.id.tab_mine:
                    viewPager.setCurrentItem(3, false);
                    break;
            }
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    bottomBar.selectTabWithId(R.id.tab_home);
                    break;
                case 1:
                    bottomBar.selectTabWithId(R.id.tab_more);
                    break;
                case 2:
                    bottomBar.selectTabWithId(R.id.tab_order);
                    break;
                case 3:
                    bottomBar.selectTabWithId(R.id.tab_mine);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}