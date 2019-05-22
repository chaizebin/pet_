package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.jk.CommonApplication;
import com.jk.mapper.PetMapper;
import com.jk.model.Classification;
import com.jk.model.OtherBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetMapper petMapper;

    @Override
    public List<Classification> queryClassificationById(Integer pid) {
        List<Classification> classification=petMapper.queryClassificationById(pid);
        for(Classification classi:classification){
            Integer classificationId = classi.getId();
            List<Classification> classifications = queryClassificationById(classificationId);
            classi.setNodes(classifications);

        }
        return classification;
    }

    @Override
    public JSONObject queryOrderForPage(OtherBean otherBean) {
        List<OtherBean> total=petMapper.queryOrderForPage(otherBean);
        PageHelper.startPage(otherBean.getPage(),otherBean.getRows());
        List<OtherBean> otherList=petMapper.queryOrderForPage(otherBean);
        JSONObject jsonObject = new JSONObject();
        Double size = Double.valueOf(total.size());
        double a = size / Double.valueOf(otherBean.getRows());
        double ceil = Math.ceil(a);
        if(otherBean.getPage()!=1 && otherBean.getPage()>ceil){
            otherList=null;
        }
        jsonObject.put("total",total.size());
        jsonObject.put("rows",otherList);
        return jsonObject;
    }


}
