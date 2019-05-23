package com.jk.dao;

import com.jk.model.Image;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MainDao {

    @Select("select * from t_img")
    List<Image> initLunBoTu();
}
