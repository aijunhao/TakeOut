package com.aijunhao.takeout.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aijunhao.takeout.R;
import com.aijunhao.takeout.model.net.bean.GoodsTypeInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author Aijunhao
 * @Time 2018-11-07 18:46
 * @Description
 */
public class GoodsTypeAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<GoodsTypeInfo> goodsTypeInfoList;

    public GoodsTypeAdapter(Context context) {
        this.context = context;
    }

    public GoodsTypeAdapter(Context context, List<GoodsTypeInfo> goodsTypeInfoList) {
        this.context = context;
        this.goodsTypeInfoList = goodsTypeInfoList;
    }

    public void setGoodsTypeInfoList(List<GoodsTypeInfo> goodsTypeInfoList) {
        this.goodsTypeInfoList = goodsTypeInfoList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.takeout_recyce_item_type, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).setData(goodsTypeInfoList, position);
    }

    @Override
    public int getItemCount() {
        return goodsTypeInfoList != null ? goodsTypeInfoList.size() : 0;
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_Count)
        TextView tvCount;
        @BindView(R.id.tv_type_name)
        TextView tvTypeName;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(List<GoodsTypeInfo> goodsTypeInfoList, int position){
            GoodsTypeInfo goodsTypeInfo = goodsTypeInfoList.get(position);
            if (goodsTypeInfo.getCount() == 0){
                tvCount.setVisibility(View.INVISIBLE);
            } else {
                tvCount.setVisibility(View.VISIBLE);
                tvCount.setText(goodsTypeInfo.getCount());
            }
            tvTypeName.setText(goodsTypeInfo.getName());
        }
    }
}
