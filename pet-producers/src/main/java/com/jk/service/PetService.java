package com.jk.service;

import com.jk.CommonApplication;
import com.jk.model.Classification;

import java.util.List;

public interface PetService {

    List<Classification> queryClassificationById(Integer pid);
}
