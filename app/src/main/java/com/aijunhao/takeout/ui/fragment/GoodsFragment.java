package com.aijunhao.takeout.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aijunhao.takeout.R;
import com.aijunhao.takeout.dagger.component.fragment.DaggerGoodsFragmentComponent;
import com.aijunhao.takeout.dagger.module.fragment.GoodsFragmentModule;
import com.aijunhao.takeout.model.net.bean.Seller;
import com.aijunhao.takeout.presenter.fragment.GoodsFragmentPresenter;
import com.aijunhao.takeout.ui.adapter.GoodsTypeAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * @Author Aijunhao
 * @Time 2018-11-06 20:46
 * @Description
 */
public class GoodsFragment extends BaseFragment {

    @BindView(R.id.rv_goods_type)
    RecyclerView rvGoodsType;
    @BindView(R.id.slhlv_goods)
    StickyListHeadersListView slhlvGoods;
    Unbinder unbinder;


    @Inject
    public GoodsFragmentPresenter goodsFragmentPresenter;
    public Seller seller;
    private GoodsTypeAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerGoodsFragmentComponent.builder().goodsFragmentModule(new GoodsFragmentModule(this)).build().in(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.takeout_fragment_goods, null);
        unbinder = ButterKnife.bind(this, view);

        // 设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvGoodsType.setLayoutManager(linearLayoutManager);
        adapter = new GoodsTypeAdapter(this.getContext());
        rvGoodsType.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        seller = (Seller) getArguments().getSerializable("seller");
        goodsFragmentPresenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public GoodsTypeAdapter getAdapter() {
        return adapter;
    }
}
