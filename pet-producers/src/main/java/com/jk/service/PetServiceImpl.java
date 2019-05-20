package com.jk.service;

import com.jk.CommonApplication;
import com.jk.mapper.PetMapper;
import com.jk.model.Classification;
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


}
