package com.wang.eurekaconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/**
 * 调用其他服务，
 * value ：服务名字
 * fallback: 异常回调处理接口
 * url 和name有什么区别？？
 * configuartion 配置类别
 */
@Service
@FeignClient(value = "serviceProvider")
public interface UserService {

    @RequestMapping(value = "/test/getUser",method = RequestMethod.GET)
    public Map<String,Object> getUser(@RequestParam("id") Integer id);

}
