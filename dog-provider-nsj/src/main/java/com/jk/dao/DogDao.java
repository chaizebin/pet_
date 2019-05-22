package com.jk.dao;


import com.jk.model.DogBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DogDao {
    
    int queryDogCount(@Param("dogBean") DogBean dogBean);

    List<DogDao> queryDogList(@Param("start") int start, @Param("rows") Integer rows,@Param("dogBean") DogBean dogBean);

    @Insert("INSERT into t_dog(dogName,baoyou,xiaoliang,kucun,weidao,dianpuid,dogprice,areaname,chanpinid,baozhiqi,xinghao)\n" +
            "        values(#{dogName},#{baoyou},#{xiaoliang},#{kucun},#{weidao},#{dianpuId},#{dogPrice},#{areaName},#{chanpinId},#{baozhiqi},#{xinghao})")
    void saveDog(DogBean dogBean);

    void delDogById(Integer[] ids);

    @Select("select td.dogid,td.dogname,td.baoyou,td.xiaoliang,td.kucun,td.weidao,td.dianpuid,td.dogprice,td.areaname,td.chanpinid,td.baozhiqi,td.xinghao from t_dog td where td.dogId = #{value}")
    DogBean findDogById(Integer id);

    @Update("update t_dog set dogId = #{dogId},dogName = #{dogName},baoyou = #{baoyou},xiaoliang = #{xiaoliang},kucun = #{kucun},weidao = #{weidao},dianpuid = #{dianpuId},dogPrice = #{dogPrice},areaname = #{areaName},chanpinId = #{chanpinId},baozhiqi = #{baozhiqi},xinghao = #{xinghao} where dogId = #{dogId}")
    void updateDog(DogBean dogBean);
}
