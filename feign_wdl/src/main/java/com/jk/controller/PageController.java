package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("toShuizu")
   public String toShuizu(){
        return "shuizulist";
    }

    @RequestMapping("toAddlist")
    public String toAddlist(){
        return "addlist";
    }

    @RequestMapping("toUpdatelist")
    public String toUpdatelist(){
        return "updatelist";
    }

    //跳转到修改
    @RequestMapping("toEditPage")
    public String toEditPage() {
        return "updatelist";
    }

    //跳转到宠物资讯查询页面
    @RequestMapping("toZixun")
    public String toZixun(){
        return "zixunlist";
    }

    //跳转到宠物资讯新增
    @RequestMapping("toAddzixun")
    public String toAddzixun(){
        return "addZixunList";
    }
    //跳转到宠物资讯修改
    @RequestMapping("toUpdzixun")
    public String toUpdzixun(){
        return "updateZixunList";
    }


    @RequestMapping("toZXye1")
    public String toZXye1(){
        return "zxye1";
 }

    @RequestMapping("toZXye2")
    public String toZXye2(){
        return "zxye2";
 }


}
