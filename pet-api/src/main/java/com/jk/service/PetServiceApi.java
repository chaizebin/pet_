package com.jk.service;


import com.jk.model.Classification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PetServiceApi {

    @GetMapping("queryGoodsById")
    List<Classification> queryClassificationById(@RequestParam("pid") Integer pid);
}
