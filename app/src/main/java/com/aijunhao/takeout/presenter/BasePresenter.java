package com.aijunhao.takeout.presenter;


import com.aijunhao.takeout.model.net.api.ResponseInfoApi;
import com.aijunhao.takeout.model.net.bean.ResponseInfo;
import com.aijunhao.takeout.utils.Constant;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by p on 2016/8/24.
 */
public abstract class BasePresenter {

    protected ResponseInfoApi responseInfoApi;
    protected CallbackAdapter callback;
    protected Gson gson;

    public BasePresenter(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        responseInfoApi = retrofit.create(ResponseInfoApi.class);
        callback = new CallbackAdapter();
        gson = new Gson();
    }

    public class CallbackAdapter implements Callback<ResponseInfo>{

        @Override
        public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {
            System.out.println("数据加载成功");
            int code = Integer.parseInt(response.body().getCode());
            System.out.println("code:" + code);
            if(code == 0){
                //把数据解析成你定义的类型
                parseDestInfo(response.body().getData());
            }
        }

        @Override
        public void onFailure(Call<ResponseInfo> call, Throwable t) {
            System.out.println("加载数据失败"+ t.getMessage());
        }
    }

    // 获取服务端数据
    public abstract void getData();

    // 解析数据
    protected abstract void parseDestInfo(String json);
}
