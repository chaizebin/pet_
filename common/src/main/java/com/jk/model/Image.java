package com.jk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName pet_
 * @ClassName Image
 * @Description TODO
 * @Author Mr.Zhang
 * @Date 2019/5/20 16:29
 * @Version 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    private Integer imgId;

    private String imgName;

    private String href;

}
