package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.dao.PetLoginDao;
import com.jk.model.ConstantConf;
import com.jk.model.PetUserBean;
import com.jk.model.UserBean;
import com.jk.service.PetLoginService;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.Md5Util;
import com.jk.utils.stutas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class PetLoginController implements PetLoginService {

    @Autowired
    private PetLoginDao petLoginDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("petReg")
    @Override
    public HashMap<String, Object> petReg(@RequestBody PetUserBean petUserBean,@RequestParam("smsCode")String smsCode) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        int count=petLoginDao.findcCountAccount(petUserBean.getAccount(),petUserBean.getPhone());
        if(count <= 0 && petUserBean != null) {
            petUserBean.setPassword(Md5Util.getMd516(petUserBean.getPassword()));

            String val = "";
            Random random = new Random(); // 随机生成器
            for (int i = 0; i < 8; i++) {
                // 在[0,2)值域随机生成一个数除2，得到以下要判断的格式
                String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
                if ("char".equalsIgnoreCase(str)) {
                    // 产生字母（大小写判断）
                    int nextInt = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    // 字符串拼接
                    val += (char) (nextInt + random.nextInt(26));
                } else if ("num".equalsIgnoreCase(str)) { // 产生随机数字并转成字符串
                    val = String.valueOf(random.nextInt(10));
                }
            }
            Object attribute = redisTemplate.opsForValue().get(ConstantConf.SMS_LOGIN_CODE+petUserBean.getPhone());
            if(attribute ==null) {
                result.put("code", 1);
                result.put("msg", "验证码错误");
                return result;
            }
            if(!smsCode.equals(attribute.toString())) {
                result.put("code", 1);
                result.put("msg", "验证码错误");
                return result;
            }

            petUserBean.setName(val);
            petLoginDao.petReg(petUserBean);
            result.put("code", 0);
            result.put("msg", "注册成功");
            return result;
        }else {
            result.put("code", 1);
            result.put("msg", "注册失败");
            return result;
        }
    }

    @RequestMapping("findSmsCode")
    @Override
    public HashMap<String, Object> findSmsCode(@RequestParam("phone") String phone) {
        HashMap<String, Object> params = new HashMap<>();
        HashMap<String, Object> result = new HashMap<>();
        Object lock = redisTemplate.opsForValue().get(ConstantConf.SMS_LOCK_LOGIN+phone);
        if(lock != null) {
            result.put("code", 1);
            result.put("msg", "一分钟之内只能发送一次验证码");
            return result;
        }
        params.put("accountSid", ConstantConf.ACCOUNTSID );
        params.put("templateid",ConstantConf.TEMPLATEID);
        params.put("to", phone);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time =  sdf.format(new Date());
        params.put("timestamp", time);
        String i = ConstantConf.ACCOUNTSID+ConstantConf.AUTH_TOKEN+time;
        String md532 = Md5Util.getMd532(i);
        params.put("sig", md532);
        int random = (int) Math.ceil(Math.random()*899999+100000);
        System.out.println(random);
        redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_CODE+phone, random, ConstantConf.SMS_LOGIN_TIME, TimeUnit.SECONDS);
        //session.setAttribute(loginNumber, random);
        params.put("param",random);
        String post = HttpClientUtil.post(ConstantConf.REST_URL, params);
        JSONObject parseObject = JSON.parseObject(post);
        String respCode = parseObject.getString("respCode");
        System.out.println(respCode);
        if(ConstantConf.SMS_SUCCESS.equals(respCode)) {
            //当前用加一个一分钟不能获取的锁
            redisTemplate.opsForValue().set(ConstantConf.SMS_LOCK_LOGIN+phone, "lock", ConstantConf.SMS_LOCK_LOGIN_TIME, TimeUnit.MINUTES);

            result.put("code", 0);
            result.put("msg", "发送成功");
            return result;
        }else {
            result.put("code", 1);
            result.put("msg", "发送失败");
            return result;
        }
    }

    @RequestMapping("petLogin")
    @Override
    public HashMap<String, Object> petLogin(@RequestBody PetUserBean petUserBean) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();

        PetUserBean petUserBean1 = petLoginDao.findUserInfoAccount(petUserBean.getAccount());
        if(petUserBean1 == null) {
            result.put("code", 2);
            result.put("msg", "账号不存在");
            return result;
        }
        String md516 = Md5Util.getMd516(petUserBean.getPassword());
        if(!md516.equals(petUserBean1.getPassword())){
            result.put("code", 3);
            result.put("msg", "密码不正确");
            return result;
        }
        session.setAttribute(session.getId(), petUserBean1);
        result.put("code", 0);
        result.put("msg", "登录成功");
        return result;
    }

    @RequestMapping("findDuanXin")
    @Override
    public String findDuanXin(@RequestParam("phone") String phone) {
        /*用户手机号 key加上状态   判断用户是否登陆过*/
        Boolean aBoolean = redisTemplate.hasKey(ConstantConf.SMS_LOGIN_CODE + phone);
        if (aBoolean) {
            Integer stua = (Integer) redisTemplate.opsForValue().get(ConstantConf.SMS_Login_STATUS_CODE + phone);
            if (stua == null) {
                redisTemplate.opsForValue().set(ConstantConf.SMS_Login_STATUS_CODE + phone, stua, 24, TimeUnit.HOURS);
                return "次数已用完";
            }

            Object lock = redisTemplate.opsForValue().get(ConstantConf.SMS_LOCK_LOGIN + phone);
            if (lock != null) {
                return "距离上一次获取验证码不超过一分钟";
            }
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("accountSid", ConstantConf.ACCOUNTSID);
            params.put("to", phone);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            params.put("timestamp", timestamp);
            String sig = Md5Util.getMd532(ConstantConf.ACCOUNTSID + ConstantConf.AUTH_TOKEN + timestamp);
            params.put("sig", sig);
            params.put("templateid", ConstantConf.TEMPLATEID);

            String str = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
            Random r = new Random();
            String arr[] = new String[4];
            String b = "";
            for (int i = 0; i < 4; i++) {
                int n = r.nextInt(62);

                arr[i] = str.substring(n, n + 1);
                b += arr[i];

            }
            params.put("param", b);
            System.out.println(b);
            //session.setAttribute(phone, b);
            redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_CODE + phone, b, ConstantConf.SMS_LOCK_LOGIN_TIME, TimeUnit.MINUTES);
            String string = HttpClientUtil.post(ConstantConf.REST_URL, params);
            JSONObject parseObject = JSON.parseObject(string);
            System.out.println(parseObject);
            String respCode = parseObject.getString("respCode");
            if ("00000".equals(respCode)) {
                Integer stuw = (Integer) redisTemplate.opsForValue().get(ConstantConf.SMS_Login_STATUS_CODE + phone);
                Integer sta = stuw - 1;
                System.out.println(sta);
                redisTemplate.opsForValue().set(ConstantConf.SMS_Login_STATUS_CODE + phone, sta);
                //给当前用户加一个一分钟内不嫩获取验证码
                redisTemplate.opsForValue().set(ConstantConf.SMS_LOCK_LOGIN + phone, "lock", ConstantConf.SMS_LOCK_LOGIN_TIME, TimeUnit.MINUTES);
                return "发送验证码成功!";
            }
            return "验证码发送失败！";

        } else {
            Integer stua = (Integer) redisTemplate.opsForValue().get(ConstantConf.SMS_Login_STATUS_CODE + phone);
            if (stua != null) {
                if (stua == 1) {
                    redisTemplate.opsForValue().set(ConstantConf.SMS_Login_STATUS_CODE + phone, stua, 24, TimeUnit.HOURS);
                    return "次数已用完";
                }
            }
            Object lock = redisTemplate.opsForValue().get(ConstantConf.SMS_LOCK_LOGIN + phone);
            if (lock != null) {
                return "距离上一次获取验证码不超过一分钟";
            }
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("accountSid", ConstantConf.ACCOUNTSID);
            params.put("to", phone);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            params.put("timestamp", timestamp);
            String sig = Md5Util.getMd532(ConstantConf.ACCOUNTSID + ConstantConf.AUTH_TOKEN + timestamp);
            params.put("sig", sig);
            params.put("templateid", ConstantConf.TEMPLATEID);

            String str = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
            Random r = new Random();
            String arr[] = new String[4];
            String b = "";
            for (int i = 0; i < 4; i++) {
                int n = r.nextInt(62);

                arr[i] = str.substring(n, n + 1);
                b += arr[i];

            }
            params.put("param", b);
            System.out.println(b);
            //session.setAttribute(phone, b);
            redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_CODE + phone, b, ConstantConf.SMS_LOCK_LOGIN_TIME, TimeUnit.MINUTES);
            String string = HttpClientUtil.post(ConstantConf.REST_URL, params);
            JSONObject parseObject = JSON.parseObject(string);
            System.out.println(parseObject);
            String respCode = parseObject.getString("respCode");
            if ("00000".equals(respCode)) {
                stutas stu = new stutas();
                Integer stuw = stu.getSts();
                System.out.println(stuw);
                redisTemplate.opsForValue().set(ConstantConf.SMS_Login_STATUS_CODE + phone, stuw);
                //给当前用户加一个一分钟内不嫩获取验证码
                redisTemplate.opsForValue().set(ConstantConf.SMS_LOCK_LOGIN + phone, "lock", ConstantConf.SMS_LOCK_LOGIN_TIME, TimeUnit.MINUTES);
                return "发送验证码成功!";
            }

            return "验证码发送失败！";
        }
    }

    @RequestMapping("quickLogin")
    @Override
    public String quickLogin(@RequestParam("phone") String phone,@RequestParam("code") String code) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Object attribute = redisTemplate.opsForValue().get(ConstantConf.SMS_LOGIN_CODE + phone);
        if (!code.equals(attribute.toString()) && !code.equals("")) {
            return "验证码不正确";
        }
        //把用户存到redis
        redisTemplate.opsForValue().set(ConstantConf.SMS_LOGIN_PHONE+phone,phone);
        session.setAttribute(session.getId(),phone);
        return "登录成功";
    }


}
