package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Classification;
import com.jk.model.OtherBean;
import com.jk.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("pet")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("queryGoodsById")
    @ResponseBody
    public List<Classification> queryClassificationById(@RequestParam("pid") Integer pid){
        System.out.println("1111111111111111111");
        List<Classification> list = new ArrayList<>();
         list=petService.queryClassificationById(pid);
        return list;
    }
    @RequestMapping("queryOrderForPage")
    @ResponseBody
    public JSONObject queryOrderForPage(OtherBean otherBean){
        return petService.queryOrderForPage(otherBean);

    }

}
