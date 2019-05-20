package com.jk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.jk.dao.CatDao;
import com.jk.model.Cat;
import com.jk.model.Region;
import com.jk.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName pet_
 * @ClassName CatServiceImpl
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/17 8:56
 * @Version 1.0
 **/
@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDao catDao;

    @Override
    public JSONObject queryCatForPage(Cat cat) {
        List<Cat> total = catDao.queryCatForPage(cat);
        PageHelper.startPage(cat.getPage(),cat.getRows());
        List<Cat> catList = catDao.queryCatForPage(cat);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",total.size());
        jsonObject.put("rows",catList);
        return jsonObject;
    }

    @Override
    public Boolean delCatById(String ids) {
        int count = catDao.delCatById(ids);
        return count > 0 ? true : false;
    }

    @Override
    public Boolean saveOrUpCat(Cat cat) {
        int count = 0;
        if (cat.getCatId()==null){
            cat.setDianPuId(0);
            count= catDao.saveCat(cat);
        }else {
            count = catDao.updateCat(cat);
        }
        return count ==1 ? true : false;
    }

    @Override
    public Cat queryCatById(Integer id) {
        return catDao.queryCatById(id);
    }

    @Override
    public List<Region> queryRegion(Integer id) {
        return catDao.queryRegion(id);
    }
}
