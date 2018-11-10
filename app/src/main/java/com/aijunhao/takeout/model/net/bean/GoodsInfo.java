package com.aijunhao.takeout.model.net.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @Author Aijunhao
 * @Time 2018-11-07 18:08
 * @Description
 */
public class GoodsInfo {


    /**
     * bargainPrice : true
     * form : 肉末烧汁茄子+榄菜肉末四季豆+小食+时蔬+含粗粮米饭)
     * icon : http://192.168.226.1:8080/TakeoutService/imgs/goods/caiping_taocan.webp
     * id : 1002
     * monthSaleNum : 37
     * name : 肉末烧汁茄子+四季豆套餐(含粗粮米饭)
     * new : false
     * newPrice : 13.899999618530273
     * oldPrice : 30
     */

    private boolean bargainPrice;
    private String form;
    private String icon;
    private int id;
    private int monthSaleNum;
    private String name;
    private boolean isNew;
    private double newPrice;
    private int oldPrice;

    private int typeId;
    private String typeName;

    public GoodsInfo() {
    }

    public GoodsInfo(boolean bargainPrice, String form, String icon, int id, int monthSaleNum, String name, boolean isNew, double newPrice, int oldPrice, int typeId, String typeName) {
        this.bargainPrice = bargainPrice;
        this.form = form;
        this.icon = icon;
        this.id = id;
        this.monthSaleNum = monthSaleNum;
        this.name = name;
        this.isNew = isNew;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public boolean isBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(boolean bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonthSaleNum() {
        return monthSaleNum;
    }

    public void setMonthSaleNum(int monthSaleNum) {
        this.monthSaleNum = monthSaleNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "bargainPrice=" + bargainPrice +
                ", form='" + form + '\'' +
                ", icon='" + icon + '\'' +
                ", id=" + id +
                ", monthSaleNum=" + monthSaleNum +
                ", name='" + name + '\'' +
                ", isNew=" + isNew +
                ", newPrice=" + newPrice +
                ", oldPrice=" + oldPrice +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
