package com.aijunhao.takeout.domine;

/**
 * @Author Aijunhao
 * @Time 2018/10/31 21:45
 * @Description
 */
public class ActivityInfo {

    private int id;
    private int type;
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ActivityInfo{" +
                "id=" + id +
                ", type=" + type +
                ", info='" + info + '\'' +
                '}';
    }
}
