package com.aijunhao.takeout.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aijunhao.takeout.R;
import com.aijunhao.takeout.model.net.bean.Seller;
import com.aijunhao.takeout.ui.adapter.BusinessActivityVPAdapter;
import com.aijunhao.takeout.ui.fragment.BusinessFragment;
import com.aijunhao.takeout.ui.fragment.CommentFragment;
import com.aijunhao.takeout.ui.fragment.GoodsFragment;
import com.flipboard.bottomsheet.BottomSheetLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BusinessActivity extends AppCompatActivity {

    @BindView(R.id.ib_back)
    ImageButton ibBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ib_menu)
    ImageButton ibMenu;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.bottomSheetLayout)
    BottomSheetLayout bottomSheetLayout;
    @BindView(R.id.imgCart)
    ImageView imgCart;
    @BindView(R.id.tvSelectNum)
    TextView tvSelectNum;
    @BindView(R.id.tvCountPrice)
    TextView tvCountPrice;
    @BindView(R.id.tvDeliveryFee)
    TextView tvDeliveryFee;
    @BindView(R.id.tvSendPrice)
    TextView tvSendPrice;
    @BindView(R.id.tvSubmit)
    TextView tvSubmit;
    @BindView(R.id.bottom)
    LinearLayout bottom;
    @BindView(R.id.fl_Container)
    FrameLayout flContainer;

    String[] tabNames = new String[]{
            "商品", "评价", "商家"
    };

    public List<Fragment> listFragment = new ArrayList<>();
    private Seller seller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takeout_activity_business);
        ButterKnife.bind(this);

        seller = (Seller) getIntent().getSerializableExtra("seller");

        tvTitle.setText(seller.getName());
        tvDeliveryFee.setText("另需配送费￥" + seller.getDeliveryFee() + "元");
        tvSendPrice.setText("起送费");

        //创建tab
        createTabs();
        //创建Fragment
        createFragmentList();

        BusinessActivityVPAdapter vpAdapter = new BusinessActivityVPAdapter(getSupportFragmentManager(), listFragment);
        vp.setAdapter(vpAdapter);
        //关联ViewPger和TabLayout   注意：一定要重写Adapter里面的一个方法getPageTitle(int position)
        tabs.setupWithViewPager(vp);
        //设置页面滑动监听
        vp.addOnPageChangeListener(new MyOnPageChangeListener());
    }

    private void createFragmentList() {
        for (int i = 0; i < tabNames.length; i++) {
            Fragment fragment = null;
            switch (i) {
                case 0:
                    fragment = new GoodsFragment();
                    break;
                case 1:
                    fragment = new CommentFragment();
                    break;
                case 2:
                    fragment = new BusinessFragment();
                    break;
            }
            //给Fragment传递参数
            Bundle args = new Bundle();
            args.putString("title", tabNames[i]);
            args.putSerializable("seller", seller);
            fragment.setArguments(args);
            listFragment.add(fragment);
        }
    }

    private void createTabs() {
        for (int i = 0; i < tabNames.length; i++) {
            //添加Tab
            tabs.addTab(tabs.newTab().setText(tabNames[i]));
        }
    }

    @OnClick({R.id.ib_back, R.id.ib_menu, R.id.tvSubmit, R.id.bottom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ib_back:
                finish();
                break;
            case R.id.ib_menu:
                break;
            case R.id.tvSubmit:
                break;
            case R.id.bottom:
                break;
        }
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //页面被选中
        @Override
        public void onPageSelected(int position) {
            if (position == 0) {
                bottom.setVisibility(View.VISIBLE);
            } else {
                bottom.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
