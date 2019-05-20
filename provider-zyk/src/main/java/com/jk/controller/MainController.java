package com.jk.controller;

import com.jk.model.Image;
import com.jk.service.MainService;
import com.jk.service.MainServicePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName pet_
 * @ClassName MainController
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/20 16:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("main")
public class MainController implements MainService {

    @Autowired
    private MainServicePro mainServicePro;

    @Override
    @RequestMapping("initLunBoTu")
    public List<Image> initLunBoTu() {
        return mainServicePro.initLunBoTu();
    }
}
