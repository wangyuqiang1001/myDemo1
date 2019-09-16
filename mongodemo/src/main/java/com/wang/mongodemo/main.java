package com.wang.mongodemo;

import com.mongodb.MongoClient;
import com.wang.mongodemo.bean.User;
import org.springframework.data.mongodb.core.MongoTemplate;

public class main {


    public static void main(String[] args) {
        MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("localhost", 27017), "test");
        User user = new User();
        user.setId(103);
        user.setUserName("103userName");
        user.setDescription("测试描述呀");
        mongoTemplate.insert(user);
    }
}
