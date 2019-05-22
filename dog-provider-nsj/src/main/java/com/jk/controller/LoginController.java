package com.jk.controller;

import com.jk.dao.LoginDao;
import com.jk.model.UserBean;
import com.jk.service.LoginService;
import com.jk.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class LoginController implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @RequestMapping("loginUser")
    @Override
    public HashMap<String, Object> login(@RequestBody UserBean userBean) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        UserBean userBean2 = loginDao.findUserInfousername(userBean.getUserName());
        System.out.println(userBean2);
        if(userBean2 == null) {
            result.put("code", 2);
            result.put("msg", "账号不存在");
            return result;
        }
        String md516 = Md5Util.getMd516(userBean.getPassword());
        if(!md516.equals(userBean2.getPassword())){
            result.put("code", 3);
            result.put("msg", "密码不正确");
            return result;
        }
        session.setAttribute(session.getId(), userBean2);
        result.put("code", 0);
        result.put("msg", "登录成功");
        return result;
    }

    @RequestMapping("regUser")
    @Override
    public HashMap<String,Object> regUser(@RequestBody UserBean userBean) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        int count=loginDao.findcCountusername(userBean.getUserName());
        if(count<=0 && userBean != null) {
            userBean.setPassword(Md5Util.getMd516(userBean.getPassword()));
            loginDao.regUser(userBean);
            result.put("code", 0);
            result.put("msg", "注册成功");
            return result;
        }else {
            result.put("code", 1);
            result.put("msg", "注册失败");
            return result;
        }
    }
}
