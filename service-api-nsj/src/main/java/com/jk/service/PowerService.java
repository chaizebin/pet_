package com.jk.service;

import com.jk.model.PowerBean;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface PowerService {

    @RequestMapping("findPowerList")
    List<PowerBean> findPowerList();
}
