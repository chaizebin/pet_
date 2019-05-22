package com.jk.service;

import com.jk.model.UserBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface LoginService {

    @RequestMapping("loginUser")
    HashMap<String, Object> login(@RequestBody UserBean userBean);

    @RequestMapping("regUser")
    HashMap<String,Object> regUser(@RequestBody UserBean userBean);
}
