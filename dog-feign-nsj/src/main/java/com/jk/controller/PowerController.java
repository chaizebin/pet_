package com.jk.controller;

import com.jk.model.PowerBean;
import com.jk.service.PowerServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PowerController {

    @Autowired
    private PowerServiceFeign powerServiceFeign;

    //导航树查询
    @RequestMapping("findPowerList")
    public List<PowerBean> findPowerList(){
        List<PowerBean> powerList = powerServiceFeign.findPowerList();
        return powerList;
    }
}
