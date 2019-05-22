package com.jk.dao;

import com.jk.model.PowerBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PowerDao {

    @Select("select * from t_power where pid = #{value}")
    List<PowerBean> findPowerByPid(Integer pid);
}
