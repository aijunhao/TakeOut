package com.aijunhao.takeout.ui.fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aijunhao.takeout.R;
import com.aijunhao.takeout.dagger.component.fragment.DaggerHomeFragmentComponent;
import com.aijunhao.takeout.dagger.module.fragment.HomeFragmentModule;
import com.aijunhao.takeout.model.net.bean.Seller;
import com.aijunhao.takeout.presenter.fragment.HomeFragmentPresenter;
import com.aijunhao.takeout.ui.adapter.HomeRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author Aijunhao
 * @Time 2018/11/5 19:11
 * @Description
 */
public class HomeFragment extends BaseFragment {

    private static final String TAG = HomeFragment.class.getSimpleName();

    /**
     * 头容器颜色
     */
    private static final int TRANSPARENT_COLOR = 0x553190E8;
    private static final int UN_TRANSPARENT_COLOR = 0xff3190E8;

    @BindView(R.id.rv_home)
    RecyclerView rvHome;
    @BindView(R.id.ll_title_space)
    LinearLayout llTitleSpace;
    @BindView(R.id.tv_home_address)
    TextView tvHomeAddress;
    @BindView(R.id.iv_weather)
    ImageView ivWeather;
    @BindView(R.id.tv_temperature)
    TextView tvTemperature;
    @BindView(R.id.ll_title_search)
    LinearLayout llTitleSearch;
    @BindView(R.id.ll_title_container)
    LinearLayout llTitleContainer;
    Unbinder unbinder;
    @BindView(R.id.iv_address)
    ImageView ivAddress;

    /**
     * recyclerView滚动量及头部透明度设置
     */
    private int sumY = 0;       // recyclerView移动的增量
    private float duration = 150.0f;     // 增量的最大值
    private int Height = 50;        // 空白头容器高
    private float alpha;            // 头容器中控件透明度
    private ArgbEvaluator evaluator = new ArgbEvaluator();      // 透明度计算器

    private HomeRecyclerViewAdapter adapter;

    @Inject
    HomeFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerHomeFragmentComponent.builder().homeFragmentModule(new HomeFragmentModule(this)).build().in(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        getTestData();
        adapter = new HomeRecyclerViewAdapter(this.getContext());
        rvHome.setAdapter(adapter);
        rvHome.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        rvHome.addOnScrollListener(listener);

        // 获取服务端的数据
        presenter.getData();
    }

    /**
     * recyclerview的列表测试数据
     */
//    private void getTestData() {
//        List<Seller> nearBySellers = new ArrayList<>();
//        List<Seller> otherSellers = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Seller seller = new Seller();
//            seller.setName("附近商家" + i);
//            nearBySellers.add(seller);
//        }
//        for (int i = 9; i < 100; i++) {
//            Seller seller = new Seller();
//            seller.setName("普通商家" + i);
//            otherSellers.add(seller);
//        }
//        rvHome.setAdapter(new HomeRecyclerViewAdapter(nearBySellers, otherSellers));
//    }


    private RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            // 滑动增量
//            Log.e(TAG, "RecyclerView = [" + recyclerView + "], dx = [" + dx + "], dy = [" + dy + "]");
            sumY += dy;

            alpha = 1 - sumY / duration;
            // 根据增量值得到透明度
            int bgColor;
            if (sumY < 0) {
                bgColor = TRANSPARENT_COLOR;
            } else if (sumY > duration) {
                bgColor = UN_TRANSPARENT_COLOR;
            } else {
                bgColor = (int) evaluator.evaluate(sumY / duration, TRANSPARENT_COLOR, UN_TRANSPARENT_COLOR);
            }
            // 设置头容器的背景色
            llTitleContainer.setBackgroundColor(bgColor);
            // 设置头容器中的透明度
            tvHomeAddress.setAlpha(alpha);
            ivWeather.setAlpha(alpha);
            ivAddress.setAlpha(alpha);
            tvTemperature.setAlpha(alpha);

            LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) llTitleSpace.getLayoutParams();
            if (sumY <= 0) {
                linearParams.height = Height;
            } else if (sumY >= duration) {
                linearParams.height = 0;
            } else {
                linearParams.height = (int) (Height * alpha);
            }
            llTitleSpace.setLayoutParams(linearParams);
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public HomeRecyclerViewAdapter getAdapter() {
        return adapter;
    }
}
