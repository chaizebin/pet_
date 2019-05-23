package com.jk.mapper;

import com.jk.model.Classification;
import com.jk.model.EchartsBean;
import com.jk.model.OtherBean;
import com.jk.model.TreeBean;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PetMapper {

    List<Classification> queryClassificationById(@RequestParam("pid") Integer pid);

    List<OtherBean> queryOrderForPage(OtherBean otherBean);

    List<TreeBean> findTreeByPid(int pid);

    List<EchartsBean> query();
}
