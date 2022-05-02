package com.daydream.javaee.mapper;

import com.daydream.javaee.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User row);

    int insertSelective(User row);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);
}