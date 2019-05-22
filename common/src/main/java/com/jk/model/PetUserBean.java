package com.jk.model;

import junit.framework.TestCase;
import lombok.Data;

import java.util.Random;

@Data
public class PetUserBean{

    private Integer id;

    private String account;

    private String password;

    private String name;

    private String phone;

}
