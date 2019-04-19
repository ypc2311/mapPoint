package com.mapdemo.model;

public class MapPoint {
    private int id;
    private String pointLng;
    private String pointLat;
    private String name;
    private String icon;
    private int status;
    private String text;
    private String str1;
    private String str2;
    private String createTime;
    private String updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointLng() {
        return pointLng;
    }

    public void setPointLng(String pointLng) {
        this.pointLng = pointLng;
    }

    public String getPointLat() {
        return pointLat;
    }

    public void setPointLat(String pointLat) {
        this.pointLat = pointLat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    @Override
    public String toString() {
        return "MapPoint{" +
                "id=" + id +
                ", pointLng='" + pointLng + '\'' +
                ", pointLat='" + pointLat + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", status='" + status + '\'' +
                ", text='" + text + '\'' +
                ", str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
