package com.jk.mapper;

import com.jk.model.ShuizuBean;
import com.jk.model.ZixunBean;
import com.jk.model.ZxtypeBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShuizuMapper {

//查询
   // long queryShuizuTotal();

   // List<ShuizuBean> queryShuizuList(@Param("start") Integer page, @Param("rows") Integer rows);

    long findCount(@Param("shuizuBean") ShuizuBean shuizuBean);

    List<ShuizuBean> findShuizuPage(@Param("start") Integer start, @Param("rows") Integer rows,@Param("shuizuBean") ShuizuBean shuizuBean);



    //删除
    Boolean delShuiById(Integer[] ids);


    //新增
    int saveShui(ShuizuBean shuizuBean);

    //修改
    Boolean updateShui(ShuizuBean shuizuBean);

    //回显
    ShuizuBean findShuiByid(Integer id);


    //查询资讯查询

    long queryCount(@Param("zixunBean") ZixunBean zixunBean);

    List<ZixunBean> findZixunPage(@Param("start")Integer start,@Param("rows") Integer rows,@Param("zixunBean") ZixunBean zixunBean);



//宠物资讯类型
    @Select("select * from t_zxtype")
    List<ZxtypeBean> findZixunType();
//宠物资讯删除
    Boolean delZixunById(Integer[] ids);
//宠物资讯新增
    int saveZixun(ZixunBean zixunBean);
//宠物资讯修改
    Boolean updateZixun(ZixunBean zixunBean);
//宠物资讯回显
    ZixunBean findZixunByid(Integer id);


}