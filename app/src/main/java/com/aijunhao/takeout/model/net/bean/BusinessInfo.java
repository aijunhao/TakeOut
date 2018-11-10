package com.aijunhao.takeout.model.net.bean;

import java.util.List;

/**
 * @Author Aijunhao
 * @Time 2018-11-07 18:07
 * @Description
 */
public class BusinessInfo {
    private List<GoodsTypeInfo> list;

    public BusinessInfo() {
    }

    public BusinessInfo(List<GoodsTypeInfo> list) {
        this.list = list;
    }

    public List<GoodsTypeInfo> getList() {
        return list;
    }

    public void setList(List<GoodsTypeInfo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BusinessInfo{" +
                "list=" + list +
                '}';
    }
}
