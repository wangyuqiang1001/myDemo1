package com.wang.mongodemo.dao;

import com.wang.mongodemo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoTestDao {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 保存对象
     *
     * @param user
     */
    public User saveUser(User user) {
        return mongoTemplate.save(user, "user");
    }

    /**
     * 查询对象
     *
     * @param name
     * @return
     */
    public List<User> findUserByUserName(String name) {
        Query query = new Query(Criteria.where("userName").is(name));
        List<User> userList = mongoTemplate.find(query, User.class);
        return userList;
    }


    /**
     * 删除用户
     *
     * @param id
     */
    public Long removeUser(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        long deletedCount = mongoTemplate.remove(query, User.class).getDeletedCount();
        System.out.println("删除元素个数:" + deletedCount);
        return deletedCount;
    }


    /**
     * 跟新用户
     *
     * @param user
     */
    public Long updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName",user.getDescription());
        long modifiedCount = mongoTemplate.updateFirst(query, update, User.class, "user").getModifiedCount();
        System.out.println("更新元素个数:" + modifiedCount);
        return modifiedCount;
    }
}
