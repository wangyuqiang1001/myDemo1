package com.wang.eurekaconsumer.control;

import com.wang.eurekaconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/out")
public class Test {

    @Autowired
    private UserService userService;
@RequestMapping(value = "/a")
    public Map<String ,Object> getMap(){
    return  userService.getUser(1);
}
}
