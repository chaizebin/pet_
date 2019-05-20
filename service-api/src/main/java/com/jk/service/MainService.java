package com.jk.service;

import com.jk.model.Image;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface MainService {
    @RequestMapping("/main/initLunBoTu")
    List<Image> initLunBoTu();
}
