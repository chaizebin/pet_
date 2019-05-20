package com.jk.service;

import com.jk.model.Classification;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient("pet-provider")
public interface PetService extends PetServiceApi{

}
