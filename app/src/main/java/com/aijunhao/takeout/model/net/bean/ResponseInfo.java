package com.aijunhao.takeout.model.net.bean;

/**
 * @Author Aijunhao
 * @Time 2018-11-06 18:42
 * @Description
 */
public class ResponseInfo {

    private String code;
    private String data;

    public ResponseInfo() {
    }

    public ResponseInfo(String code, String data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
