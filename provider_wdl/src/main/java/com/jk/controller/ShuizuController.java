package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.ShuizuBean;
import com.jk.model.ZixunBean;
import com.jk.model.ZxtypeBean;
import com.jk.service.ShuizuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class ShuizuController {

    @Autowired
    private ShuizuService shuizuService;
//查询
    @RequestMapping("findShuizu")
    @ResponseBody
   /*public Map<String,Object> findShuizu(Integer page,Integer rows,ShuizuBean shuizuBean){
       // System.out.println("page"+page+"rows"+rows);
    return shuizuService.findShuizu(page,rows,shuizuBean);
    }*/

    public HashMap<String,Object> findShuizu(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody ShuizuBean shuizuBean){

        return shuizuService.findShuizu(page,rows,shuizuBean);
    }

  //删除
  @RequestMapping("delShuiById")
  @ResponseBody
   public Boolean delShuiById(@RequestBody Integer[] ids){
     return shuizuService.delShuiById(ids);

  }
    //新增 修改
    @RequestMapping("saveShui")
    @ResponseBody
    public Boolean saveShui(@RequestBody ShuizuBean shuizuBean){
        if (shuizuBean.getShuizuid()!=null){
            return shuizuService.updateShui(shuizuBean);//修改
        }else {
            return shuizuService.saveShui(shuizuBean);//回显
        }
    }

  //回显
  @RequestMapping("findShuiByid")
  @ResponseBody
    public ShuizuBean findShuiByid(@RequestParam Integer id){

    return shuizuService.findShuiByid(id);
  }





    //宠物资讯查询
    @RequestMapping("findZixunPage")
    @ResponseBody
    public HashMap<String,Object> findZixunPage(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody ZixunBean zixunBean){
        //System.out.println("page"+page+"rows"+rows+"zixunBean"+zixunBean);
        return shuizuService.findZixunPage(page,rows,zixunBean);
    }

    //宠物资讯类型
    @RequestMapping("findZixunType")
    @ResponseBody
    public List<ZxtypeBean> findZixunType(){
        return shuizuService.findZixunType();

    }

   //宠物资讯删除
   @RequestMapping("delZixunById")
   @ResponseBody
   public Boolean delZixunById(@RequestBody Integer[] ids){
       return shuizuService.delZixunById(ids);

   }
//宠物资讯新增 修改
   @RequestMapping("saveZixun")
    @ResponseBody
   public Boolean saveZixun(@RequestBody ZixunBean zixunBean){
       if (zixunBean.getId()!=null){
           return shuizuService.updateZixun(zixunBean);//修改
       }else {
           return shuizuService.saveZixun(zixunBean);//回显
       }
   }


    //宠物资讯回显
    @RequestMapping("findZixunByid")
    @ResponseBody
    public ZixunBean findZixunByid(@RequestParam Integer id){

        return shuizuService.findZixunByid(id);
    }

}
