package com.jk.service;

import com.jk.model.ShuizuBean;
import com.jk.model.ZixunBean;
import com.jk.model.ZxtypeBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ShuizuService  {

    //查询
    //Map<String, Object> findShuizu(Integer page, Integer rows, ShuizuBean shuizuBean);
    HashMap<String, Object> findShuizu(Integer page, Integer rows, ShuizuBean shuizuBean);

    //删除
    Boolean delShuiById(Integer[] ids);

   //修改
    Boolean updateShui(ShuizuBean shuizuBean);
   //新增
    Boolean saveShui(ShuizuBean shuizuBean);
  //回显
    ShuizuBean findShuiByid(Integer id);


    //宠物资讯查询
    HashMap<String, Object> findZixunPage(Integer page, Integer rows, ZixunBean zixunBean);

//宠物资讯类型
    List<ZxtypeBean> findZixunType();

//宠物资讯删除
    Boolean delZixunById(Integer[] ids);


 //宠物资讯修改
    Boolean updateZixun(ZixunBean zixunBean);
//宠物资讯新增
    Boolean saveZixun(ZixunBean zixunBean);
//宠物资讯回显
    ZixunBean findZixunByid(Integer id);


}
