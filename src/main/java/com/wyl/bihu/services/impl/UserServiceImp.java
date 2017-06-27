package com.wyl.bihu.services.impl;

import com.wyl.bihu.Mapper.UserMapper;
import com.wyl.bihu.Model.BaseUserInfo;
import com.wyl.bihu.Model.UserInfo;
import com.wyl.bihu.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/23.
 */
@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserInfo userInfo) {
        userMapper.insert(userInfo);
        return 1;
    }

    @Override
    public UserInfo findByEmail(String email) {
        return userMapper.findByEmail(email);
    }
}
