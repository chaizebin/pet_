package com.jk.service;

import com.jk.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: springcloud_house
 * @Date: 2019/4/17 8:46
 * @Author: 袁硕
 * @Description:
 */
@FeignClient("huoti-provider")
public interface HuotiServiceFeign {

    @GetMapping("selectHuoti")
    List<HuotiBean> selectHuoti(HuotiBean huotiBean);

    @PostMapping("selectHuotiPage")
    Map<String, Object> selectHuotiPage(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows,@RequestBody HuotiBean huotiBean);

    @DeleteMapping("deleteHuotiById")
    void deleteHuotiById(Integer id);

    @DeleteMapping("delAllHuoti")
    void delAllHuoti(@RequestParam("ss") String ss);

    @GetMapping("selectHuotiById")
    HuotiBean selectHuotiById(@RequestParam("id") Integer id);

    @PutMapping("updateHuoti")
    void updateHuoti(HuotiBean huotiBean);


    @RequestMapping("saveHuoti")
    Boolean saveHuoti(@RequestBody HuotiBean huotiBean);

    @RequestMapping("findHuotiByid")
    HuotiBean findHuotiByid(@RequestParam Integer id);
}
