package com.jk.controller;

import com.jk.model.HuotiBean;
import com.jk.service.HuotiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class HuotiController {

    @Autowired
    private HuotiService huotiService;

    /**
     *
     * @return
     */
    @GetMapping("selectHuoti")
    @ResponseBody
    public List<HuotiBean> selectHuoti(HuotiBean huotiBean){

        return huotiService.selectHuoti(huotiBean);
    }

    /*
    查询分页
     */
    @PostMapping("selectHuotiPage")
    @ResponseBody
    public Map<String,Object> selectHuotiPage(@RequestParam("page") Integer page ,@RequestParam("rows") Integer rows,@RequestBody HuotiBean huotiBean){
        System.out.println(page+"--"+rows+huotiBean);
        return huotiService.selectHuotiPage(page,rows,huotiBean);
    }


    /*
    单删
     */
    @DeleteMapping("deleteHuotiById")
    @ResponseBody
    public void deleteHuotiById( Integer id){
        System.out.println(id);
        huotiService.deleteHuotiById(id);
    }


    /*
    批删
     */
    @DeleteMapping("delAllHuoti")
    @ResponseBody
    public void delAllHuoti(String ss){
        System.out.println(ss+"------------------");
        huotiService.delAllHuoti(ss);
    }

    //回显
    @RequestMapping("findHuotiByid")
    @ResponseBody
    public HuotiBean findHuotiByid(@RequestParam Integer id){

        return huotiService.findHuotiByid(id);
    }


    //新增 修改
    @RequestMapping("saveHuoti")
    @ResponseBody
    public Boolean saveHuoti(@RequestBody HuotiBean huotiBean){
        if (huotiBean.getId()!=null){
            return huotiService.updateHuoti(huotiBean);//修改
        }else {
            return huotiService.saveHuoti(huotiBean);//回显
        }
    }

}
