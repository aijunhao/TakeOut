package com.aijunhao.takeout.presenter.fragment;

import android.util.Log;

import com.aijunhao.takeout.model.net.bean.BusinessInfo;
import com.aijunhao.takeout.model.net.bean.GoodsInfo;
import com.aijunhao.takeout.model.net.bean.GoodsTypeInfo;
import com.aijunhao.takeout.model.net.bean.ResponseInfo;
import com.aijunhao.takeout.presenter.BasePresenter;
import com.aijunhao.takeout.ui.fragment.GoodsFragment;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * @Author Aijunhao
 * @Time 2018-11-07 16:55
 * @Description
 */
public class GoodsFragmentPresenter extends BasePresenter{

    private static final String TAG = GoodsFragmentPresenter.class.getName();
    private GoodsFragment goodsFragment;

    /**
     * 商品列表
     */
    private List<GoodsInfo> goodsInfoList = new ArrayList<>();

    @Inject
    public GoodsFragmentPresenter(GoodsFragment goodsFragment) {
        this.goodsFragment = goodsFragment;
    }

    @Override
    public void getData() {
        Call<ResponseInfo> goodsInfo = responseInfoApi.getGoodsInfo((int) goodsFragment.seller.getId());
        goodsInfo.enqueue(callback);
    }

    @Override
    protected void parseDestInfo(String json) {
        Log.d(TAG, json);
        List<GoodsTypeInfo> goodsTypeInfoList = gson.fromJson(json,new TypeToken<List<GoodsTypeInfo>>(){}.getType());
        Log.d(TAG, goodsTypeInfoList.size() + "");
        dealData(goodsTypeInfoList);
        goodsFragment.getAdapter().setGoodsTypeInfoList(goodsTypeInfoList);
        goodsFragment.getAdapter().notifyDataSetChanged();
    }

    /**
     * 处理数据，为类型列表和商品列表提供
     * @param list
     */
    private void dealData(List<GoodsTypeInfo> list) {
        for (int i=0; i<list.size(); i++){
            GoodsTypeInfo goodsTypeInfo = list.get(i);
            Log.d(TAG, goodsTypeInfo.toString());
            for (int j=0; j<goodsTypeInfo.getList().size(); j++){
                GoodsInfo goodsInfo = goodsTypeInfo.getList().get(j);
                goodsInfo.setTypeId(goodsTypeInfo.getId());
                goodsInfo.setTypeName(goodsTypeInfo.getName());
                goodsInfoList.add(goodsInfo);
                Log.d(TAG, goodsInfo.toString());
            }
        }
    }
}
