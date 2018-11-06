package com.aijunhao.takeout.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author Aijunhao
 * @Time 2018-11-06 20:54
 * @Description
 */
public class BusinessActivityAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public BusinessActivityAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**
     * 配置TabLayout与ViewPager，重写此方法，获得getArguments()传过来的标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentList.get(position).getArguments().getString("title");
    }
}
