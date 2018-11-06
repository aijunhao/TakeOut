package com.aijunhao.takeout.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aijunhao.takeout.R;

/**
 * @Author Aijunhao
 * @Time 2018/11/5 19:11
 * @Description
 */
public class MoreFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, null);
        return view;
    }
}
