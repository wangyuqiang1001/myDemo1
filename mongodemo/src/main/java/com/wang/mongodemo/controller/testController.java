package com.wang.mongodemo.controller;

import com.wang.mongodemo.bean.User;
import com.wang.mongodemo.dao.MongoTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private MongoTestDao mongoTestDao;

    @RequestMapping(value = "/testAdd", method = RequestMethod.POST)
    public String testAdd(@RequestBody User user) {
        return mongoTestDao.saveUser(user).toString();
    }


    @RequestMapping(value = "/testDelete", method = RequestMethod.POST)
    public String testDelete(Integer id) {
        return mongoTestDao.removeUser(id).toString();
    }


    @RequestMapping(value = "/testUpdate", method = RequestMethod.POST)
    public String testUpdate(@RequestBody User user) {
        return mongoTestDao.updateUser(user).toString();
    }


    @RequestMapping(value = "/testQuery", method = RequestMethod.POST)
    public String testQuery(String userName) {
        return mongoTestDao.findUserByUserName(userName).toString();
    }

}
