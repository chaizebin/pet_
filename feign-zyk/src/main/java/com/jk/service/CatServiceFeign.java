package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("provider-zyk")
public interface CatServiceFeign extends CatServiceApi {
}
