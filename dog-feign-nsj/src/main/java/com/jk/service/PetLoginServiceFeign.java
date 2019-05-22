package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "provider-nsj")
public interface PetLoginServiceFeign extends PetLoginService{
}
