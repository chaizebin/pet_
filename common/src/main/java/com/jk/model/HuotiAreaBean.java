package com.jk.model;

/**
 * @program: pet_
 * @Date: 2019/5/20 10:26
 * @Author: 袁硕
 * @Description:
 */
public class HuotiAreaBean {
    private  Integer id;
    private  String name;
    private  Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "HouseAreaBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                '}';
    }
}
