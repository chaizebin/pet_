package com.jk.service;

import com.jk.model.PetUserBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

public interface PetLoginService {

    @RequestMapping("petReg")
    HashMap<String, Object> petReg(@RequestBody PetUserBean petUserBean,@RequestParam("smsCode")String smsCode);

    @RequestMapping("findSmsCode")
    HashMap<String, Object> findSmsCode(@RequestParam("phone") String phone);

    @RequestMapping("petLogin")
    HashMap<String, Object> petLogin(@RequestBody PetUserBean petUserBean);

    @RequestMapping("findDuanXin")
    String findDuanXin(@RequestParam("phone") String phone);

    @RequestMapping("quickLogin")
    String quickLogin(@RequestParam("phone") String phone,@RequestParam("code") String code);
}
