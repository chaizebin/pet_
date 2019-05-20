package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Cat;
import com.jk.model.Region;

import java.util.List;

public interface CatService {
    JSONObject queryCatForPage(Cat cat);

    Boolean delCatById(String ids);

    Boolean saveOrUpCat(Cat cat);

    Cat queryCatById(Integer id);

    List<Region> queryRegion(Integer id);
}
