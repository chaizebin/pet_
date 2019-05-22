package com.jk.controller;

import com.jk.model.UserBean;
import com.jk.service.LoginServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Random;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceFeign loginServiceFeign;

    @RequestMapping("loginUser")
    public HashMap<String,Object> login(UserBean userBean){
        return loginServiceFeign.login(userBean);
    }

    @RequestMapping("regUser")
    public HashMap<String,Object> regUser(UserBean userBean){
        return loginServiceFeign.regUser(userBean);
    }



}
