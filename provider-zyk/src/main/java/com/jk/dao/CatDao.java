package com.jk.dao;

import com.jk.model.Cat;
import com.jk.model.Region;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CatDao {

    List<Cat> queryCatForPage(Cat cat);

    @Delete("delete from t_cat where catId in (${_parameter})")
    int delCatById(String ids);

    int saveCat(Cat cat);

    int updateCat(Cat cat);

    @Select("select * from t_cat where catId = #{id}")
    Cat queryCatById(Integer id);

    @Select("select r.region_id as regionId , r.region_name as regionName , r.region_pid as regionPid from t_region r where r.region_pid = #{pid}")
    List<Region> queryRegion(Integer id);
}
