package com.hp.service;

import com.hp.entity.UserInfo;
import com.hp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserInfo selectUserById(Integer i) {
        return userMapper.selectByPrimaryKey(i);
    }
}
