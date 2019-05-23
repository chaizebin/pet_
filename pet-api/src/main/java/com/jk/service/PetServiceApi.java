package com.jk.service;


import com.alibaba.fastjson.JSONObject;
import com.jk.model.Classification;
import com.jk.model.EchartsBean;
import com.jk.model.OtherBean;
import com.jk.model.TreeBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PetServiceApi {

    @GetMapping("queryGoodsById")
    List<Classification> queryClassificationById(@RequestParam("pid") Integer pid);

    @RequestMapping("queryOrderForPage")
    JSONObject queryOrderForPage(@RequestBody OtherBean otherBean);
    @GetMapping("queryTree")
    List<TreeBean> queryTree();
    @RequestMapping("query")
    List<EchartsBean> query();
}
