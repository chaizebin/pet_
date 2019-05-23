package com.jk.service.impl;

import com.jk.dao.MainDao;
import com.jk.model.Image;
import com.jk.service.MainServicePro;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName pet_
 * @ClassName MainServiceProImpl
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/20 16:34
 * @Version 1.0
 **/
@Service
public class MainServiceProImpl implements MainServicePro {

    @Autowired
    private MainDao mainDao;

    @Override
    public List<Image> initLunBoTu() {
        return mainDao.initLunBoTu();
    }
}
