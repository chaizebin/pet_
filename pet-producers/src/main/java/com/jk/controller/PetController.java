package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.CommonApplication;
import com.jk.model.Classification;
import com.jk.model.EchartsBean;
import com.jk.model.OtherBean;
import com.jk.model.TreeBean;
import com.jk.service.PetService;
import com.jk.service.PetServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetController implements PetServiceApi{

    @Autowired
    private PetService petService;

    @GetMapping("queryGoodsById")
    @ResponseBody
    @Override
    public List<Classification> queryClassificationById(@RequestParam("pid") Integer pid){

        return petService.queryClassificationById(pid);
    }

    @Override
    @RequestMapping("queryOrderForPage")
    @ResponseBody
    public JSONObject queryOrderForPage(@RequestBody OtherBean otherBean) {
        return petService.queryOrderForPage(otherBean);


    }
    @GetMapping("queryTree")
    @Override
    @ResponseBody
    public List<TreeBean> queryTree() {
        return petService.queryTree();
    }
    @RequestMapping("query")
    @Override
    @ResponseBody
    public List<EchartsBean> query() {
        return petService.query();
    }


}
