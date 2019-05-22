package com.jk.dao;

import com.jk.model.PetUserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface PetLoginDao {

    @Select("select count(1) from t_petuser where account = #{account} or phone = #{phone}")
    int findcCountAccount(String account, String phone);

    @Insert("insert into t_petuser(account,password,phone,name) values (#{account},#{password},#{phone},#{name})")
    void petReg(PetUserBean petUserBean);

    @Select("select * from t_petuser where account = #{account}")
    PetUserBean findUserInfoAccount(String account);
}
