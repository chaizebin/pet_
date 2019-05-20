package com.jk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName pet_
 * @ClassName Region
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/20 11:27
 * @Version 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    private Integer regionId;

    private String regionName;

    private Integer regionPid;

}
