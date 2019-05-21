package com.jk.service;

import com.jk.model.*;

import java.util.List;
import java.util.Map;


public interface HuotiService {

    Map<String, Object> selectHuotiPage(Integer page, Integer rows, HuotiBean huotiBean);

    void deleteHuotiById(Integer id);

    void delAllHuoti(String ss);




    List<HuotiBean> selectHuoti(HuotiBean huotiBean);




    Boolean updateHuoti(HuotiBean huotiBean);

    Boolean saveHuoti(HuotiBean huotiBean);

    HuotiBean findHuotiByid(Integer id);
}
