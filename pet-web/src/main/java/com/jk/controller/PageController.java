package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("goHomePage")
    public String goHomePage(){
        return "homePage";
    }
    @RequestMapping("goOther")
    public String goOther(){
        return "other";
    }
    @RequestMapping("goEchart")
    public String goEchart(){
        return "echarts";
    }
}
