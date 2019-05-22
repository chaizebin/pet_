package com.jk.model;

public class ConstantConf {

    //短信登录
    public static final String ACCOUNTSID = "17e7e155982e4607a8e2f83ac1b7ddc9";

    public static final String AUTH_TOKEN = "96fcff2444144283b7ffe1d979e3c0c9";
    //模板ID
    public static final String TEMPLATEID = "1460525554";
    //短信接口
    public static final String REST_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
    //默认状态
    public static final String SMS_SUCCESS = "00000";
    //短信登录验证
    public static final String SMS_LOGIN_CODE ="dlyzm";
    //过期时间
    public static final Integer SMS_LOGIN_TIME = 60;
    //一分钟之内只能发送一次锁
    public static final Integer SMS_LOCK_LOGIN_TIME = 1;
    //短信验证码一分钟有效期锁
    public static final String SMS_LOCK_LOGIN = "lock";
    //短信验证码状态超过三次今天不能登录
    public  static final String   SMS_Login_STATUS_CODE = "yzmzt";
    //将用户登录手机号存在redis中
    public  static  final String  SMS_LOGIN_PHONE = "sjh";
    //浏览记录粗在redis
    public  static  final String  SMS_LOOK_RECORD_PET ="lljl";
}
