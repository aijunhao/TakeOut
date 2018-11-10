package com.aijunhao.takeout.dagger.module.fragment;

import com.aijunhao.takeout.ui.fragment.GoodsFragment;

import dagger.Module;
import dagger.Provides;

/**
 * @Author Aijunhao
 * @Time 2018-11-07 16:57
 * @Description
 */
@Module
public class GoodsFragmentModule {

    GoodsFragment goodsFragment;

    public GoodsFragmentModule(GoodsFragment goodsFragment) {
        this.goodsFragment = goodsFragment;
    }

    @Provides
    GoodsFragment providerGoodsFragment(){
        return goodsFragment;
    }
}
