package com.jk.controller;

import com.jk.dao.PowerDao;
import com.jk.model.PowerBean;
import com.jk.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class PowerController implements PowerService {

    @Autowired
    private PowerDao powerDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("findPowerList")
    @Override
    public List<PowerBean> findPowerList() {
        int pid = 0;
        return  powerNode(pid);
    }

    private List<PowerBean> powerNode(@RequestParam("pid") Integer pid) {
        List<Object> range = redisTemplate.opsForList().range("powerNode" + pid, 0, -1);
        List<PowerBean> result = new ArrayList<PowerBean>();
        if(range != null && range.size() >0){
            result = (List<PowerBean>) range.get(0);
        }else {
            result = powerDao.findPowerByPid(pid);
            redisTemplate.opsForList().leftPush("powerNode" + pid,result);
            redisTemplate.expire("powerNode" + pid,10,TimeUnit.SECONDS);
        }
        for (PowerBean powerBean:result) {
            List<PowerBean> powers = powerNode(powerBean.getId());
            if (powers != null && powers.size() >0){
                powerBean.setNodes(powers);
                powerBean.setSelectable(false);
            }else {
                powerBean.setSelectable(true);
            }
        }
        return result;
    }
}
