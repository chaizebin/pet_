package com.jk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName pet_
 * @ClassName Cat
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/16 20:36
 * @Version 1.0
 **/
@Data
@ToString
public class Cat {

    private Integer page;

    private Integer rows;


    private Integer catId;

    /**
     * 猫咪名称
     */
    private String catName;

    private String cityName;

    private String provinceName;

    /**
     * 猫咪价格
     */
    private String catPrice;

    /**
     * 是否包邮
     */
    private String baoYou;

    /**
     * 发货地
     */
    private String faHuoDi;

    /**
     * 销量
     */
    private int xiaoLiang;

    /**
     * 库存
     */
    private int kuCun;

    /**
     * 店铺id
     */
    private Integer dianPuId;

    /**
     * 商品图片
     */
    private String catImg;
}
