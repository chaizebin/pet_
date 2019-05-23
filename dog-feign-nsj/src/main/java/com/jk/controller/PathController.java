package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {

    @RequestMapping("todog")
    public String todog(){
        return "/dogList";
    }

    @RequestMapping("todogadd")
    public String todogadd(){
        return "/dogadd";
    }


    @RequestMapping("topower")
    public String topower(){
        return "/powerList";
    }

    @RequestMapping("tologin")
    public String tologin(){
        return "/login";
    }

    @RequestMapping("toreg")
    public String toreg(){
        return "/reg";
    }

    @RequestMapping("topetLogin")
    public String topetLogin(){
        return "/petLogin";
    }

    @RequestMapping("topetReg")
    public String topetReg(){
        return "/petReg";
    }
}
