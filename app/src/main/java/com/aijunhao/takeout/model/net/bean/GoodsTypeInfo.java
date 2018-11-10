package com.aijunhao.takeout.model.net.bean;

import java.util.List;

/**
 * @Author Aijunhao
 * @Time 2018-11-07 18:08
 * @Description
 */
public class GoodsTypeInfo {
    private int id;
    private String info;
    private List<GoodsInfo> list;
    private String name;
    private int count;      // 同意类型选中的数量

    public GoodsTypeInfo() {
    }

    public GoodsTypeInfo(int id, String info, List<GoodsInfo> list, String name, int count) {
        this.id = id;
        this.info = info;
        this.list = list;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<GoodsInfo> getList() {
        return list;
    }

    public void setList(List<GoodsInfo> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GoodsTypeInfo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", list=" + list +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
