package com.jk.controller;

import com.jk.model.HuotiBean;
import com.jk.service.HuotiServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller

public class HuotiController {

    @Autowired
    private HuotiServiceFeign huotiServiceFeign;

    /**
     *
     * @return
     */
    @GetMapping("selectHuoti")
    @ResponseBody
    public List<HuotiBean> selectHuoti(HuotiBean huotiBean){
        System.out.println("1");
        return huotiServiceFeign.selectHuoti(huotiBean);

    }

    @RequestMapping ("selectHuotiPage")
    @ResponseBody
    public Map<String,Object> selectHuotiPage(Integer page , Integer rows,HuotiBean huotiBean){
        System.out.println(page+"--"+rows+huotiBean);
        return huotiServiceFeign.selectHuotiPage(page,rows,huotiBean);
    }

    @DeleteMapping("deleteHuotiById")
    @ResponseBody
    public void deleteHuotiById(Integer id){
        System.out.println(id);
        huotiServiceFeign.deleteHuotiById(id);
    }
    @DeleteMapping("delAllHuoti")
    @ResponseBody
    public void delAllHuoti(String ss){
        System.out.println("删除id:--"+ss);
        huotiServiceFeign.delAllHuoti(ss);
    }

    @GetMapping("selectHuotiById")
    @ResponseBody
    public HuotiBean selectHuotiById(Integer id){
        System.out.println(id);
        return huotiServiceFeign.selectHuotiById(id);
    }
    @PutMapping("updateHuoti")
    @ResponseBody
    public  void updateHuoti(@RequestBody HuotiBean huotiBean){
        System.out.println(huotiBean);
        huotiServiceFeign.updateHuoti(huotiBean);
    }

    //新增
    @RequestMapping("saveHuoti")
    @ResponseBody
    public Boolean saveHuoti(HuotiBean huotiBean){
        return huotiServiceFeign.saveHuoti(huotiBean);
    }

    //回显
    @RequestMapping("findHuotiByid")
    @ResponseBody
    public HuotiBean findHuotiByid(Integer id){
        return huotiServiceFeign.findHuotiByid(id);
    }


}
