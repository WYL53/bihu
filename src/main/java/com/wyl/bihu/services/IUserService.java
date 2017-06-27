package com.wyl.bihu.services;

import com.wyl.bihu.Model.BaseUserInfo;
import com.wyl.bihu.Model.UserInfo;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface IUserService {
    int addUser(UserInfo userInfo);
    UserInfo findByEmail(String uid);
}
