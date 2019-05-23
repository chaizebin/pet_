package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.Cat;
import com.jk.model.Region;
import com.jk.service.CatServiceFeign;
import com.jk.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @ProjectName pet_
 * @ClassName CatController
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/17 15:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("cat")
public class CatController {

    @Autowired
    private CatServiceFeign catServiceFeign;

    @RequestMapping("queryCatForPage")
    public JSONObject queryCatForPage(Cat cat){
        return catServiceFeign.queryCatForPage(cat);
    }

    @RequestMapping("delCatById")
    public Boolean delCatById(String ids){
        return catServiceFeign.delCatById(ids);
    }

    @RequestMapping("saveOrUpCat")
    public Boolean saveOrUpCat(Cat cat){
        return catServiceFeign.saveOrUpCat(cat);
    }

    @RequestMapping("queryCatById")
    public Cat queryCatById(Integer id){
        return catServiceFeign.queryCatById(id);
    }

    @RequestMapping("queryRegion")
    public List<Region> queryRegion(Integer id){
        return catServiceFeign.queryRegion(id);
    }

    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("updaloadImg")
    public String uploadImg(MultipartFile img)throws IOException {
        if (img == null || img.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(img);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        return JSONObject.toJSONString(split[0]);
    }

}
