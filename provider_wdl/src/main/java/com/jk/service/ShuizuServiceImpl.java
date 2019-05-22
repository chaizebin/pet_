package com.jk.service;

import com.jk.mapper.ShuizuMapper;
import com.jk.model.ShuizuBean;
import com.jk.model.ZixunBean;
import com.jk.model.ZxtypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShuizuServiceImpl implements ShuizuService {
    @Autowired
    private ShuizuMapper shuizuMapper;
    //查询
    @Override
    public HashMap<String, Object> findShuizu(Integer page, Integer rows, ShuizuBean shuizuBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        long sum = shuizuMapper.findCount(shuizuBean);
        int start = (page-1)*rows;
        List<ShuizuBean> list =  shuizuMapper.findShuizuPage(start,rows,shuizuBean);
        hashMap.put("total", sum);
        hashMap.put("rows", list);
        return hashMap;
    }


   // @Override
    /*public Map<String, Object> findShuizu(Integer page, Integer rows, ShuizuBean shuizuBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
       long total= shuizuMapper.queryShuizuTotal();
       int start=(page-1)*rows;
       List<ShuizuBean> list= shuizuMapper.queryShuizuList(start,rows);
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }*/


    //删除
    @Override
    public Boolean delShuiById(Integer[] ids) {
        return shuizuMapper.delShuiById(ids);
    }
//修改
    @Override
    public Boolean updateShui(ShuizuBean shuizuBean) {
        return shuizuMapper.updateShui(shuizuBean);
    }
//新增
    @Override
    public Boolean saveShui(ShuizuBean shuizuBean) {
       int count= shuizuMapper.saveShui(shuizuBean);
       if (count !=1){
           return false;
       }else {
           return true;
       }
    }

  //回显
    @Override
    public ShuizuBean findShuiByid(Integer id) {
        return shuizuMapper.findShuiByid(id);
    }

    //宠物资讯查询
    @Override
    public HashMap<String, Object> findZixunPage(Integer page, Integer rows, ZixunBean zixunBean) {
        HashMap<String, Object> hashMap = new HashMap<>();
        long sum = shuizuMapper.queryCount(zixunBean);
        int start = (page-1)*rows;
        List<ZixunBean> list =  shuizuMapper.findZixunPage(start,rows,zixunBean);
        hashMap.put("total", sum);
        hashMap.put("rows", list);
        return hashMap;
    }
//宠物资讯类型
    @Override
    public List<ZxtypeBean> findZixunType() {
        return shuizuMapper.findZixunType();
    }
//宠物资讯删除
    @Override
    public Boolean delZixunById(Integer[] ids) {
        return shuizuMapper.delZixunById(ids);
    }
//宠物资讯修改
    @Override
    public Boolean updateZixun(ZixunBean zixunBean) {
        return shuizuMapper.updateZixun(zixunBean);
    }
//宠物资讯新增
    @Override
    public Boolean saveZixun(ZixunBean zixunBean) {
        int count= shuizuMapper.saveZixun(zixunBean);
        if (count !=1){
            return false;
        }else {
            return true;
        }
    }
//宠物资讯回显
    @Override
    public ZixunBean findZixunByid(Integer id) {
        return shuizuMapper.findZixunByid(id);
    }


}

