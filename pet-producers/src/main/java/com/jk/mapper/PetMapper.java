package com.jk.mapper;

import com.jk.model.Classification;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PetMapper {

    List<Classification> queryClassificationById(@RequestParam("pid") Integer pid);
}
