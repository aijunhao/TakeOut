package com.aijunhao.takeout.model.net.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Author Aijunhao
 * @Time 2018/11/5 20:57
 * @Description 商家类
 */
public class Seller implements Serializable {

    /**
     * "id":1,
     "pic":http://xxxxxxxxxx.jpg,
     "name":"二十五块半（上地店）",

     "score":"4.4",
     "sale":4132,//销量
     "ensure":1,//是否有转送保证

     "invoice":1,//是否提供发票
     "sendPrice":20,//起送价格
     "deliveryFee":4,//配送费

     "recentVisit":1,//是否最近光顾
     "distance":"773m",
     "time":"34分钟",

     "activityList":,[{//活动列表
     "id":1,
     "type":1,// 活动类型，详见附表
     "info":"在线支付，满30减8"
     },{
     "id":2,
     "type":2,
     " info ":"16.9元特价超值套餐！"
     }]

     */
    private long id;		// id
    private String pic;	// 图片地址
    private String name;	// 商家名

    private float score;	// 评分
    private int sale;		// 销量
    private boolean ensure;	//是否有转送保证

    private boolean invoice;	//是否提供发票
    private int sendPrice;	//起送价格
    private float deliveryFee;	//配送费

    private boolean recentVisit;	//是否最近光顾
    private int distance;		// 商家距离
    private int time;		// 配送时间

    private ArrayList<ActivityInfo> activityList;		// 活动列表

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public boolean isEnsure() {
        return ensure;
    }

    public void setEnsure(boolean ensure) {
        this.ensure = ensure;
    }

    public boolean isInvoice() {
        return invoice;
    }

    public void setInvoice(boolean invoice) {
        this.invoice = invoice;
    }

    public int getSendPrice() {
        return sendPrice;
    }

    public void setSendPrice(int sendPrice) {
        this.sendPrice = sendPrice;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public boolean isRecentVisit() {
        return recentVisit;
    }

    public void setRecentVisit(boolean recentVisit) {
        this.recentVisit = recentVisit;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<ActivityInfo> getActivityList() {
        return activityList;
    }

    public void setActivityList(ArrayList<ActivityInfo> activityList) {
        this.activityList = activityList;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", pic='" + pic + '\'' +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", sale='" + sale + '\'' +
                ", ensure='" + ensure + '\'' +
                ", invoice='" + invoice + '\'' +
                ", sendPrice=" + sendPrice +
                ", deliveryFee='" + deliveryFee + '\'' +
                ", recentVisit='" + recentVisit + '\'' +
                ", distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                ", activityList=" + activityList +
                '}';
    }
}
