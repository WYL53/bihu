package com.wyl.bihu.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Administrator on 2017/6/23.
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserInfo extends BaseUserInfo {
    private String uuid;
    private String saltPassword;
    private String salt;

    public UserInfo(BaseUserInfo baseUserInfo){
        this.name = baseUserInfo.name;
        this.email = baseUserInfo.email;
    }

    public UserInfo(String uuid,String name ,String email,String password,String salt){
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.saltPassword = password;
        this.salt =  salt;
    }
}
