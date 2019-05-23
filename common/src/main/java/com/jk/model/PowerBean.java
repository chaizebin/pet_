package com.jk.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PowerBean implements Serializable {

    private static final long serialVersionUID = 4323587408306767765L;
    private Integer id;

    private String text;

    private String href;

    private Integer pid;

    private List<PowerBean> nodes;

    private Boolean checked;

    private Boolean Selectable;

}
