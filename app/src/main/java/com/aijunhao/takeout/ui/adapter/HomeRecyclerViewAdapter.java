package com.aijunhao.takeout.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.aijunhao.takeout.R;
import com.aijunhao.takeout.ui.activity.BusinessActivity;
import com.aijunhao.takeout.model.net.bean.Seller;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author Aijunhao
 * @Time 2018/11/5 20:27
 * @Description
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_TITLE = 0;
    private static final int TYPE_DIVISION = 1;
    private static final int TYPE_SELLER = 2;


    private int otherSellerNumbersInGroup = 20;
    private int divisionSum = 0;

    private Context mContext;

    private HashMap<Integer, Integer> positionToIndex = new HashMap<>();

    private List<Seller> nearBySellers = new ArrayList<>();
    private List<Seller> otherSellers = new ArrayList<>();

    public HomeRecyclerViewAdapter(Context context) {
        mContext = context;
    }

//    public HomeRecyclerViewAdapter(List<Seller> nearBySellers, List<Seller> otherSellers) {
//        this.nearBySellers = nearBySellers;
//        this.otherSellers = otherSellers;
//    }

    public void setNearBySellers(List<Seller> nearbySellers) {
        this.nearBySellers = nearbySellers;
    }

    public void setOtherSellers(List<Seller> otherSellers) {
        this.otherSellers = otherSellers;
    }

    /**
     * 根据具体的类型设置布局
     * @param parent
     * @param viewType 布局类型，与getItemViewType()中的type对应
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TYPE_TITLE:
                View titleView = View.inflate(parent.getContext(), R.layout.item_home_title, null);
                TitleHolder titleHolder = new TitleHolder(titleView);
                return titleHolder;
            case TYPE_DIVISION:
                View divisionView = View.inflate(parent.getContext(), R.layout.item_home_division, null);
                DivisionHolder divisionHolder = new DivisionHolder(divisionView);
                return divisionHolder;
            case TYPE_SELLER:
                View sellerView = View.inflate(parent.getContext(), R.layout.item_home_seller, null);
                SellerHolder sellerHolder = new SellerHolder(sellerView);
                return sellerHolder;
        }
        return null;
    }

    /**
     * 根据类型绑定数据
     *
     * @param holder
     * @param position 数据的位置
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        Log.d(this.getClass().getName(), "onBindViewHolder(): holder.getItemViewType()" + holder.getItemViewType() + "position = " + position);
        switch (holder.getItemViewType()) {
            case TYPE_TITLE:
                break;
            case TYPE_DIVISION:
                divisionSum++;
                break;
            case TYPE_SELLER:

                // 附近商家和其他商家
                // 依据position判断是从附近商家获取数据还是其他商家获取数据
                if (position - 1 < nearBySellers.size()) {
                    // nearBySellers数据 index：0 - size()+1
                    int index = position - 1;
                    ((SellerHolder) holder).setData(nearBySellers.get(index));
                } else {
                    // 从其他商家集合获取数据

                    // 将加载过的放入哈希表中，回滚时直接从表中取出数据，因为我们只设置了index加的步奏，没有设置减，所有不这样设置的话，当recyclerview回滚时会崩溃。
                    // 判断：如果positionToIndex中能通过position获取到index信息，直接到其他商家集合获取数据
                    // 获取不到，计算index，并建立position与index的对应关系
                    int index = 0;
                    if (positionToIndex.containsKey(position)) {
                        index = positionToIndex.get(position);
                    } else {
                        index = position - nearBySellers.size()  - divisionSum;

                        positionToIndex.put(position, index);
                    }
                    ((SellerHolder) holder).setData(otherSellers.get(index));
                }
                break;
        }
    }

    /**
     * 设置集合中每项的类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
//        Log.d(this.getClass().getName(), "getItemViewType(): position = " + position);
        int type = -1;
        if (position == 0) {
            type = TYPE_TITLE;
        } else if (position == nearBySellers.size() + 1) {
            type = TYPE_DIVISION;
        } else if ((position - (nearBySellers.size() + 1)) % (otherSellerNumbersInGroup + 1) == 0) {
            type = TYPE_DIVISION;
        } else {
            type = TYPE_SELLER;
        }
//        Log.d(this.getClass().getName(), "getItemViewType(): type = " + type);
        return type;
    }

    /**
     * 获取集合数量
     *
     * @return
     */
    @Override
    public int getItemCount() {

        if (nearBySellers == null && otherSellers == null) {
            return 0;
        }

        int count = 1;

        if (nearBySellers != null) {
            count += nearBySellers.size();
        }
        if (otherSellers != null) {
            count += 1;
            count += otherSellers.size() + otherSellers.size() / otherSellerNumbersInGroup;
        }
//        Log.d(this.getClass().getName(), "getItemCount(): count = " + count);
        return count;
    }

    /**
     * 自定义测试ViewHolder
     */
    private class CommonHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public CommonHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
        }
    }

    /**
     * 自定义头部ViewHolder
     */
    public class TitleHolder extends RecyclerView.ViewHolder {
        SliderLayout sliderLayout;

        public TitleHolder(View view) {
            super(view);
            sliderLayout = (SliderLayout) view.findViewById(R.id.slide);

            setSlideData(view);
        }

        private void setSlideData(View view) {

            HashMap<String, String> url_maps = new HashMap<String, String>();

            url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
            url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
            url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
            url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

            for (String desc : url_maps.keySet()) {
                TextSliderView textSliderView = new TextSliderView(view.getContext());
                textSliderView
                        .description(desc)
                        .image(url_maps.get(desc));
                sliderLayout.addSlider(textSliderView);
            }
        }
    }

    /**
     * 自定义测试ViewHolder
     */
    public class DivisionHolder extends RecyclerView.ViewHolder {

        public DivisionHolder(View view) {
            super(view);
        }
    }

    /**
     * 自定义测试ViewHolder
     */
    public class SellerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_seller)
        ImageView ivSeller;
        @BindView(R.id.tv_Count)
        TextView tvCount;
        @BindView(R.id.tv_seller_title)
        TextView tvSellerTitle;
        @BindView(R.id.iv_pic)
        ImageView ivPic;
        @BindView(R.id.ratingBar)
        RatingBar ratingBar;
        @BindView(R.id.tv_score)
        TextView tvScore;
        @BindView(R.id.tv_sale)
        TextView tvSale;
        @BindView(R.id.tv_delivery_fee)
        TextView tvDeliveryFee;
        @BindView(R.id.tv_send_price)
        TextView tvSendPrice;
        @BindView(R.id.tv_distance)
        TextView tvDistance;
        @BindView(R.id.tv_time)
        TextView tvTime;

        Seller seller;

        public SellerHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(final Seller seller) {
            this.seller = seller;

            tvSellerTitle.setText(seller.getName());
            tvScore.setText(seller.getScore() + "");
            ratingBar.setRating(seller.getScore());
            tvSale.setText(seller.getSale() + "");
            if (seller.getDistance() >= 1000) {
                tvDistance.setText(seller.getDistance() / 1000.0 + "km");
            } else {
                tvDistance.setText(seller.getDistance() + "m");
            }
            if (seller.getTime() > 60) {
                tvTime.setText(seller.getTime() / 60 + "小时" + seller.getTime() % 60 + "分钟");
            } else {
                tvTime.setText(seller.getTime() + "分钟");
            }
            tvSendPrice.setText("￥" + seller.getSendPrice() + "元起送");
            tvDeliveryFee.setText("配送费￥" + seller.getDeliveryFee() + "元");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, BusinessActivity.class);
                    intent.putExtra("seller", seller);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
