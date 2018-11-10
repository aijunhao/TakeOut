package com.aijunhao.takeout.presenter.fragment;


import android.util.Log;

import com.aijunhao.takeout.model.net.bean.ResponseInfo;
import com.aijunhao.takeout.model.net.bean.Seller;
import com.aijunhao.takeout.presenter.BasePresenter;
import com.aijunhao.takeout.ui.fragment.HomeFragment;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * @Author Aijunhao
 * @Time 2018-11-06 18:46
 * @Description
 */
public class HomeFragmentPresenter extends BasePresenter{

    HomeFragment homeFragment;

    private String TAG = HomeFragmentPresenter.class.getName();

    @Inject
    public HomeFragmentPresenter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
    }

    @Override
    public void getData() {
        Call<ResponseInfo> homeInfo = responseInfoApi.getHomeInfo();
        homeInfo.enqueue(callback);
    }

    @Override
    protected void parseDestInfo(String json) {
        try {
            Log.e(TAG, "data数据：" + json + "");
            Gson gson = new Gson();
            List<Seller> nearbySellerList = new ArrayList<>();
            List<Seller> otherSellerList = new ArrayList<>();

            JSONObject obj_data = new JSONObject(json);
            String str_body = obj_data.getString("body");
            Log.d(TAG, "str_body数据: " + str_body + "");
            JSONArray arr_body = new JSONArray(str_body);
            Log.d(TAG, "arr_body长度：" + arr_body.length());

            for (int i=0; i<arr_body.length(); i++){
                String str_type = arr_body.getJSONObject(i).getString("type");
                if ("0".equals(str_type)) {
                    String str_seller = arr_body.getJSONObject(i).getString("seller");
                    Seller seller = gson.fromJson(str_seller, Seller.class);
                    if (i<10) {
                        nearbySellerList.add(seller);
                    } else {
                        otherSellerList.add(seller);
                    }
                }
            }

            /**
             * 输出测试
             */
            for (int i=0; i<nearbySellerList.size(); i++){
                Log.d(TAG, nearbySellerList.get(i).toString());
            }
            for (int i=0; i<otherSellerList.size(); i++){
                Log.d(TAG, otherSellerList.get(i).toString());
            }


            homeFragment.getAdapter().setNearBySellers(nearbySellerList);
            homeFragment.getAdapter().setOtherSellers(otherSellerList);

            homeFragment.getAdapter().notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
