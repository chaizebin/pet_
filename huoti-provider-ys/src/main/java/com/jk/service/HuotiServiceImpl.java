package com.jk.service;

import com.jk.mapper.HuotiMapper;
import com.jk.model.HuotiBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class HuotiServiceImpl implements HuotiService {

    @Autowired
    private HuotiMapper huotiMapper;

    @Override
    public Map<String, Object> selectHuotiPage(Integer page, Integer rows, HuotiBean huotiBean) {

        Map<String, Object> hashMap = new HashMap<>();
        //查询总条数
        long total = huotiMapper.queryHuotiTotal(huotiBean);
        int  start=(page-1)*rows;
        List<HuotiBean> list=huotiMapper.selectHuotiList(start,rows,huotiBean);
        hashMap.put("total",total);
        hashMap.put("rows",list);
        return hashMap;
    }

    @Override
    public void deleteHuotiById(Integer id) {
        huotiMapper.deleteHuotiById(id);
    }

    @Override
    public void delAllHuoti(String ss) {
        Integer [] id={};
        String [] ids= ss.split(",");
        for (int i=0; i<ids.length;i++){
            System.out.println(ids[i]);
        }
        huotiMapper.delAllHuoti(ids);
    }

    @Override
    public Boolean updateHuoti(HuotiBean huotiBean) {
        return huotiMapper.updateHuoti(huotiBean);
    }

    @Override
    public Boolean saveHuoti(HuotiBean huotiBean) {
        int count= huotiMapper.saveHuoti(huotiBean);
        if (count !=1){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public HuotiBean findHuotiByid(Integer id) {
        return huotiMapper.findHuotiByid(id);
    }

    @Override
    public List<HuotiBean> selectHuoti(HuotiBean huotiBean) {
        return huotiMapper.selectHuoti(huotiBean);
    }

}
