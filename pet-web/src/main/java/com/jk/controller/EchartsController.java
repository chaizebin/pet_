package com.jk.controller;

import com.jk.model.EchartsBean;
import com.jk.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController  //相当于@Controller和@ResponseBody
@RequestMapping("echarts")
public class EchartsController {
    @Autowired
    private PetService petService;

    @RequestMapping("query")
    public HashMap<String,Object> query(){
        HashMap<String, Object> object= new HashMap<>();
        ArrayList objects1 = new ArrayList<>();
        ArrayList objects2 = new ArrayList<>();
        List<EchartsBean> list=petService.query();
        for (EchartsBean echartsBean:list) {
            //
            objects1.add(echartsBean.getName());
            objects2.add(echartsBean.getSales());
        }
        //
        object.put("name",objects1);
        object.put("sales",objects2);
        return object;
    }
}
