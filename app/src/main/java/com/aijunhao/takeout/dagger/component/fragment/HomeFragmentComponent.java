package com.aijunhao.takeout.dagger.component.fragment;

import com.aijunhao.takeout.dagger.module.fragment.HomeFragmentModule;
import com.aijunhao.takeout.ui.fragment.HomeFragment;

import dagger.Component;

/**
 * @Author Aijunhao
 * @Time 2018-11-06 19:06
 * @Description
 */
@Component (modules = HomeFragmentModule.class)
public interface HomeFragmentComponent {
    void in(HomeFragment fragment);
}
