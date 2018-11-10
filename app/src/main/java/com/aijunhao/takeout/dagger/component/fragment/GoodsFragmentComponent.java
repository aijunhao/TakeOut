package com.aijunhao.takeout.dagger.component.fragment;

import com.aijunhao.takeout.dagger.module.fragment.GoodsFragmentModule;
import com.aijunhao.takeout.ui.fragment.GoodsFragment;

import dagger.Component;
import dagger.Module;

/**
 * @Author Aijunhao
 * @Time 2018-11-07 16:59
 * @Description
 */
@Component(modules = GoodsFragmentModule.class)
public interface GoodsFragmentComponent {

    void in(GoodsFragment goodsFragment);
}
