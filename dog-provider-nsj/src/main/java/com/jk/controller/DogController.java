package com.jk.controller;

import com.jk.dao.DogDao;
import com.jk.model.DogBean;
import com.jk.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class DogController implements DogService {

    @Autowired
    private DogDao dogDao;

    @RequestMapping("queryDogList")
    @Override
    public HashMap<String, Object> queryDogList(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestBody DogBean dogBean) {
        HashMap<String, Object> params = new HashMap<>();
        int count = dogDao.queryDogCount(dogBean);
        int start = (page-1)*rows;
        List<DogDao> list = dogDao.queryDogList(start,rows,dogBean);
        params.put("total",count);
        params.put("rows",list);
        return params;
    }

    @RequestMapping("saveDog")
    @Override
    public Boolean saveDog(@RequestBody DogBean dogBean) {
        try{
            if(dogBean.getDogId() == null){
                dogDao.saveDog(dogBean);
            }else {
                dogDao.updateDog(dogBean);
            }

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("delDogById")
    @Override
    public Boolean delDogById(@RequestParam("ids") Integer[] ids) {
        try{
            dogDao.delDogById(ids);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("findDogById")
    @Override
    public DogBean findDogById(@RequestParam("id") Integer id) {
        return dogDao.findDogById(id);
    }


}
