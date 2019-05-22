package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("goHomePage")
    public String goHomePage(){
        return "homePage2";
    }
    @RequestMapping("goOther")
    public String goOther(){
        return "other";
    }
}
