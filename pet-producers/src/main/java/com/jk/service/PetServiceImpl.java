package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.jk.CommonApplication;
import com.jk.mapper.PetMapper;
import com.jk.model.Classification;
import com.jk.model.EchartsBean;
import com.jk.model.OtherBean;
import com.jk.model.TreeBean;
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

    @Override
    public List<TreeBean> queryTree() {
        int pid=0;
        List<TreeBean> list=findNodes(pid);
        return list;
    }

    @Override
    public List<EchartsBean> query() {
        return petMapper.query();
    }

    private List<TreeBean> findNodes(int pid) {
        List<TreeBean> list=petMapper.findTreeByPid(pid);
        for (TreeBean tree: list) {
            Integer id = tree.getId();
            List<TreeBean> nodes = findNodes(id);
            if(nodes.size()<=0){
                tree.setSelectable(true);
            }else {
                tree.setSelectable(false);
                tree.setNodes(nodes);
            }
        }
        return list;
    }


}
