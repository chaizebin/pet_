package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DogBean implements Serializable {

    private static final long serialVersionUID = 6142500774248561156L;
    private Integer dogId;//狗狗商品id

    private String dogName;//狗狗商品名称

    private Integer baoyou;//是否包邮

    private Integer xiaoliang;//销量

    private Integer kucun;//库存

    private String weidao;//味道

    private Integer dianpuId;//店铺id

    private BigDecimal dogPrice;//商品价格

    private String areaName;//地区

    private Integer chanpinId;//产品参数id

    private String baozhiqi;//保质期

    private String xinghao;//型号

}
