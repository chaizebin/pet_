package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.ShuizuBean;
import com.jk.model.ZixunBean;
import com.jk.model.ZxtypeBean;
import com.jk.service.ShuizuService;
import com.jk.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShuizuController {

    @Autowired
    private ShuizuService shuizuService;
//查询
    @RequestMapping("findShuizu")
    @ResponseBody
  /* public Map<String,Object> findShuizu(Integer page, Integer rows, ShuizuBean shuizuBean){
        return shuizuService.findShuizu(page,rows,shuizuBean);
    }*/

    public HashMap<String,Object> findShuizu( Integer page,  Integer rows,  ShuizuBean shuizuBean){

        return shuizuService.findShuizu(page,rows,shuizuBean);
    }
//删除
    @RequestMapping("delShuiById")
    @ResponseBody
    public Boolean delShuiById(Integer[] ids){
       /* try {
            shuizuService.delShuiById(ids);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }*/
        return shuizuService.delShuiById(ids);

    }

//新增
    @RequestMapping("saveShui")
    @ResponseBody
    public Boolean saveShui(ShuizuBean shuizuBean){
        return shuizuService.saveShui(shuizuBean);
    }

//回显
@RequestMapping("findShuiByid")
@ResponseBody
public ShuizuBean findShuiByid(Integer id){
        return shuizuService.findShuiByid(id);
}



//宠物资讯查询
    @RequestMapping("findZixunPage")
    @ResponseBody
   public HashMap<String,Object> findZixunPage(Integer page, Integer rows, ZixunBean zixunBean){
        System.out.println("123123"+zixunBean);
    return shuizuService.findZixunPage(page,rows,zixunBean);
}

    //宠物资讯类型
    @RequestMapping("findZixunType")
    @ResponseBody
    public List<ZxtypeBean> findZixunType(){
        return shuizuService.findZixunType();

    }
//宠物资讯删除
    @RequestMapping("delZixunById")
    @ResponseBody
    public Boolean delZixunById(Integer[] ids){
        return shuizuService.delZixunById(ids);

    }
    //宠物资讯新增  修改
    @RequestMapping("saveZixun")
    @ResponseBody
    public Boolean saveZixun(ZixunBean zixunBean){
      return shuizuService.saveZixun(zixunBean);
    }


//宠物资讯回显
    @RequestMapping("findZixunByid")
    @ResponseBody
    public ZixunBean findZixunByid(Integer id){

        return shuizuService.findZixunByid(id);
    }



    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("updaloadImg")
    @ResponseBody
    public String uploadImg(MultipartFile img)throws IOException {
        if (img == null || img.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(img);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        //System.out.println(split[0]);
        return JSONObject.toJSONString(split[0]);

    }
}
