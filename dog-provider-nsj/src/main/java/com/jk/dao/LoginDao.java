package com.jk.dao;

import com.jk.model.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LoginDao {

    @Select("select * from t_user where userName = #{userName}")
    UserBean findUserInfousername(String userName);

    @Select("select count(1) from t_user where userName = #{userName}")
    int findcCountusername(String userName);

    @Insert("insert into t_user(userName,password) values (#{userName},#{password})")
    void regUser(UserBean userBean);
}
