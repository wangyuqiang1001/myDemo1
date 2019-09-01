package com.joymeter.myjwt.dao;

import com.joymeter.myjwt.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface IUserRepository{

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);

}