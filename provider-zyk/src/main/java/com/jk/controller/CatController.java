package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Cat;
import com.jk.model.Region;
import com.jk.service.CatService;
import com.jk.service.CatServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName pet_
 * @ClassName CatController
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/16 20:59
 * @Version 1.0
 **/
@RestController
@RequestMapping("cat")
public class CatController implements CatServiceApi {

    @Autowired
    private CatService catService;


    @Override
    @RequestMapping("queryCatForPage")
    public JSONObject queryCatForPage(@RequestBody Cat cat){
        return catService.queryCatForPage(cat);
    }

    @Override
    @RequestMapping("delCatById")
    public Boolean delCatById(@RequestParam(value = "ids") String ids) {
        return catService.delCatById(ids);
    }

    @Override
    @RequestMapping("saveOrUpCat")
    public Boolean saveOrUpCat(@RequestBody Cat cat) {
        return catService.saveOrUpCat(cat);
    }

    @Override
    @RequestMapping("queryCatById")
    public Cat queryCatById(Integer id) {
        return catService.queryCatById(id);
    }

    @Override
    @RequestMapping("queryRegion")
    public List<Region> queryRegion(@RequestParam(value = "id") Integer id) {
        return catService.queryRegion(id);
    }


}
