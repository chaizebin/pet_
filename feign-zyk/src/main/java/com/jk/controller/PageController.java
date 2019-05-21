package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName pet_
 * @ClassName PageController
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/20 10:07
 * @Version 1.0
 **/
@Controller
public class PageController {

    @RequestMapping("/toCatShow")
    public String toCatShow(){
        return "/cat-show";
    }

    @RequestMapping("/toCatAdd")
    public String toCatAdd(){
        return "/add-cat";
    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "/main";
    }

    @RequestMapping("/toCat2Show")
    public String toCat2Show(){
        return "/cat-2show";
    }

}
