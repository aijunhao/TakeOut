package com.aijunhao.takeout.model.net.api;

import com.aijunhao.takeout.model.net.bean.ResponseInfo;
import com.aijunhao.takeout.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author Aijunhao
 * @Time 2018-11-06 18:37
 * @Description
 */
public interface ResponseInfoApi {

    @GET(Constant.HOME_URL)
    Call<ResponseInfo> getHomeInfo();

    @GET(Constant.GOODS_URL)
    Call<ResponseInfo> getGoodsInfo(@Query("sellerId")int sellerId);
}
