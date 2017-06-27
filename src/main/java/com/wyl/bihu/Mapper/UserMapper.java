package com.wyl.bihu.Mapper;

import com.wyl.bihu.Model.UserInfo;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2017/6/23.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE NAME = #{id}")
    UserInfo findById(@Param("id") String id);

    @Select("SELECT id,name,email,password,salt FROM t_user WHERE email = #{email}")
    @Results({
            @Result(id = true,property = "uuid",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email"),
            @Result(property = "saltPassword", column = "password"),
            @Result(property = "salt", column = "salt")
    })
    UserInfo findByEmail(@Param("email") String email);

    @Insert("INSERT INTO t_user(id,name, email,password,salt) " +
            "VALUES(#{uuid},#{name}, #{email},#{saltPassword},#{salt})")
    void insert(UserInfo userInfo);

}
