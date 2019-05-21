package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HuotiMapper {
    long queryHuotiTotal(@Param("huotiBean") HuotiBean huotiBean);

    List<HuotiBean> selectHuotiList(@Param("start") Integer page, @Param("rows") Integer rows, @Param("huotiBean") HuotiBean huotiBean);

    void deleteHuotiById(@Param("id") Integer id);

    void delAllHuoti(String[] ids);


    List<HuotiBean> selectHuoti(HuotiBean huotiBean);


    Boolean updateHuoti(HuotiBean huotiBean);

    int saveHuoti(HuotiBean huotiBean);

    HuotiBean findHuotiByid(Integer id);
}
