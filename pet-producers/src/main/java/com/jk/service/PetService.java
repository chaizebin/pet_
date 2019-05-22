package com.jk.service;

import com.alibaba.fastjson.JSONObject;
import com.jk.CommonApplication;
import com.jk.model.Classification;
import com.jk.model.OtherBean;

import java.util.List;

public interface PetService {

    List<Classification> queryClassificationById(Integer pid);

    JSONObject queryOrderForPage(OtherBean otherBean);
}
