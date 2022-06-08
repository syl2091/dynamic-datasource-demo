package com.lege.service;

import com.lege.annotation.DataSource;
import com.lege.mapper.UserMapper;
import com.lege.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lege
 * @Description
 * @create 2022-06-07 9:22
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @DataSource("master")
    public Integer master() {
        return userMapper.count();
    }

    @DataSource("slave")
    public Integer slave() {
        return userMapper.count();
    }

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
