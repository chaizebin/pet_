package com.jk.controller;

import com.jk.model.PetUserBean;
import com.jk.model.UserBean;
import com.jk.service.PetLoginServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PetLoginController {

    @Autowired
    private PetLoginServiceFeign petLoginServiceFeign;

    @RequestMapping("petReg")
    public HashMap<String,Object> petReg(PetUserBean petUserBean,String smsCode){
        return petLoginServiceFeign.petReg(petUserBean,smsCode);
    }

    //短信验证
    @RequestMapping("findSmsCode")
    public HashMap<String, Object> findSmsCode(String phone){
        System.out.println("手机号"+phone);
        return petLoginServiceFeign.findSmsCode(phone);
    }

    //普通登录
    @RequestMapping("petLogin")
    public HashMap<String,Object> login(PetUserBean petUserBean){
        return petLoginServiceFeign.petLogin(petUserBean);
    }

    //获取短信验证码
    @RequestMapping("findDuanXin")
    public String findDuanXin(String phone){
        return petLoginServiceFeign.findDuanXin(phone);
    }

    //短信登录
    @RequestMapping("quicklogin")
    public String quickLogin(String phone,String code){
        return petLoginServiceFeign.quickLogin(phone,code);
    }
}
