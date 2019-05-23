package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jk.model.TreeBean;
import com.jk.service.PetService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("tree")
public class TreeController {
    @Autowired
    private PetService petService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @GetMapping("queryTree")
    public List<TreeBean>  queryTree(){
        String keys="tree";
        String str = (String) redisTemplate.opsForValue().get(keys);
        List<TreeBean> list = new ArrayList<>();
        if(StringUtils.isNotEmpty(str)){
            System.out.println("走缓存了");
            list=(List) JSON.parseArray(str);
        }else {

            list=petService.queryTree();
            System.out.println("走数据库");
            String s = JSON.toJSONString(list);
            redisTemplate.opsForValue().set(keys,s,5, TimeUnit.MINUTES);
        }
        return list;
    }
}
