package com.jk.mapper;

import com.jk.model.Classification;
import com.jk.model.OtherBean;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PetMapper {

    List<Classification> queryClassificationById(@RequestParam("pid") Integer pid);

    List<OtherBean> queryOrderForPage(OtherBean otherBean);
}
