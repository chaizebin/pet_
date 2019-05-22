package com.jk.service;

import com.jk.model.DogBean;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

public interface DogService {

    @RequestMapping("queryDogList")
    HashMap<String, Object> queryDogList(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestBody DogBean dogBean);

    @RequestMapping("saveDog")
    Boolean saveDog(@RequestBody DogBean dogBean);

    @RequestMapping("delDogById")
    Boolean delDogById(@RequestParam("ids") Integer[] ids);

    @GetMapping("findDogById")
    DogBean findDogById(@RequestParam("id") Integer id);
}
