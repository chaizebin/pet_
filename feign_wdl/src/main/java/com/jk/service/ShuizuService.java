package com.jk.service;

import com.jk.model.ShuizuBean;
import com.jk.model.ZixunBean;
import com.jk.model.ZxtypeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@FeignClient("springcloud-goods-reg")
public interface ShuizuService {

    //查询
    @RequestMapping("findShuizu")
   // Map<String, Object> findShuizu(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows, ShuizuBean shuizuBean);
    HashMap<String, Object> findShuizu(@RequestParam Integer page,@RequestParam Integer rows,@RequestBody ShuizuBean shuizuBean);

    //删除
    @RequestMapping("delShuiById")
    Boolean delShuiById(@RequestBody Integer[] ids);
  //新增
    @RequestMapping("saveShui")
    Boolean saveShui(@RequestBody ShuizuBean shuizuBean);

    //回显
    @RequestMapping("findShuiByid")
    ShuizuBean findShuiByid(@RequestParam Integer id);

    //宠物资讯条查
    @RequestMapping("findZixunPage")
    HashMap<String, Object> findZixunPage(@RequestParam Integer page,@RequestParam Integer rows,@RequestBody ZixunBean zixunBean);


    //宠物资讯类型
    @RequestMapping("findZixunType")
    List<ZxtypeBean> findZixunType();
    //宠物资讯删除
    @RequestMapping("delZixunById")
    Boolean delZixunById(@RequestBody Integer[] ids);
    //宠物资讯新增和修改
    @RequestMapping("saveZixun")
    Boolean saveZixun(@RequestBody ZixunBean zixunBean);

    //宠物资讯回显
    @RequestMapping("findZixunByid")
    ZixunBean findZixunByid(@RequestParam Integer id);

}
