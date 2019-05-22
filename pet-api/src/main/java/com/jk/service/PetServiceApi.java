package com.jk.service;


import com.alibaba.fastjson.JSONObject;
import com.jk.model.Classification;
import com.jk.model.OtherBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PetServiceApi {

    @GetMapping("queryGoodsById")
    List<Classification> queryClassificationById(@RequestParam("pid") Integer pid);

    @RequestMapping("queryOrderForPage")
    JSONObject queryOrderForPage(@RequestBody OtherBean otherBean);
}
