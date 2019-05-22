package com.jk.controller;

import com.jk.model.DogBean;
import com.jk.service.DogServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class DogController {

    @Autowired
    private DogServiceFeign dogServiceFeign;

    @RequestMapping("queryDogList")
    public HashMap<String,Object> queryDogList(Integer page,Integer rows,DogBean dogBean){
        return dogServiceFeign.queryDogList(page,rows,dogBean);
    }

    @RequestMapping("saveDog")
    public Boolean saveDog(DogBean dogBean){
        return  dogServiceFeign.saveDog(dogBean);
    }

    @RequestMapping("delDogById")
    public Boolean delDogById(Integer[] ids){
        return dogServiceFeign.delDogById(ids);
    }

    @GetMapping("findDogById")
    public DogBean findDogById(Integer id){
        return dogServiceFeign.findDogById(id);
    }
}
