package com.jk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName pet_
 * @ClassName CatParameter
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/16 20:50
 * @Version 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CatParameter {

    private Integer parameterId;

    /**
     * 种类
     */
    private String zhongLei;

    /**
     * 功效
     */
    private String gongXiao;

    /**
     * 形态
     */
    private String xingTai;

    /**
     * 使用方法
     */
    private String shiYongMethod;

    /**
     * 适用对象
     */
    private String shiYongObject;

    /**
     * 病症类型
     */
    private String bingZhengType;

    /**
     * 食品口味
     */
    private String shiPinKouWei;

    /**
     * 适用阶段
     */
    private String shiYongStage;

    /**
     * 商品id
     */
    private Integer productId;

}
