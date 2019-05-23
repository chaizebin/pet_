package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "provider-nsj")
public interface DogServiceFeign extends DogService{
}
