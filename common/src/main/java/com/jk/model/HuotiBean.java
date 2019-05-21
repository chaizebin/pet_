package com.jk.model;

import lombok.Data;

/**
 * @program: pet_
 * @Date: 2019/5/20 9:45
 * @Author: 袁硕
 * @Description:
 */
public class HuotiBean {
    private Integer id;     //id
    private String name;    //名字
    private Integer price;  // 价格



    private String baoyou;  //包邮

    private String xiaoliang;   //销量
    private Integer kucun;  //库存

    private Integer province;    //城市id
    private String provinceName;    //城市名字

    private Integer city;   //地区id
    private String cityName;    //地区名字

    private Integer startprice;
    private Integer endprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBaoyou() {
        return baoyou;
    }

    public void setBaoyou(String baoyou) {
        this.baoyou = baoyou;
    }

    public String getXiaoliang() {
        return xiaoliang;
    }

    public void setXiaoliang(String xiaoliang) {
        this.xiaoliang = xiaoliang;
    }

    public Integer getKucun() {
        return kucun;
    }

    public void setKucun(Integer kucun) {
        this.kucun = kucun;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getStartprice() {
        return startprice;
    }

    public void setStartprice(Integer startprice) {
        this.startprice = startprice;
    }

    public Integer getEndprice() {
        return endprice;
    }

    public void setEndprice(Integer endprice) {
        this.endprice = endprice;
    }

    @Override
    public String toString() {
        return "HuotiBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", startprice=" + startprice +
                ", endprice=" + endprice +
                ", baoyou='" + baoyou + '\'' +
                ", xiaoliang='" + xiaoliang + '\'' +
                ", kucun=" + kucun +
                ", province=" + province +
                ", provinceName='" + provinceName + '\'' +
                ", city=" + city +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
