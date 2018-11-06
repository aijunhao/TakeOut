package com.aijunhao.takeout.dagger.module.fragment;

import com.aijunhao.takeout.presenter.fragment.HomeFragmentPresenter;
import com.aijunhao.takeout.ui.fragment.HomeFragment;

import dagger.Module;
import dagger.Provides;

/**
 * @Author Aijunhao
 * @Time 2018-11-06 19:02
 * @Description
 */
@Module
public class HomeFragmentModule {

    HomeFragment fragment;

    public HomeFragmentModule(HomeFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    HomeFragmentPresenter provideHomeFragmentPresenter(){
        return new HomeFragmentPresenter(fragment);
    }
}
