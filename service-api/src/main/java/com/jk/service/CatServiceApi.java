package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Cat;
import com.jk.model.Region;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CatServiceApi {

    @RequestMapping("/cat/queryCatForPage")
    JSONObject queryCatForPage(@RequestBody Cat cat);

    @RequestMapping("/cat/delCatById")
    Boolean delCatById(@RequestParam(value = "ids") String ids);

    @RequestMapping("/cat/saveOrUpCat")
    Boolean saveOrUpCat(@RequestBody Cat cat);

    @RequestMapping("/cat/queryCatById")
    Cat queryCatById(@RequestParam(value = "id") Integer id);

    @RequestMapping("/cat/queryRegion")
    List<Region> queryRegion(@RequestParam(value = "id") Integer id);
}
