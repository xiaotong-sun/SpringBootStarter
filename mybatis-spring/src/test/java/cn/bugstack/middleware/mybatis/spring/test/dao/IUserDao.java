package cn.bugstack.middleware.mybatis.spring.test.dao;

import cn.bugstack.middleware.mybatis.spring.test.po.User;

public interface IUserDao {

     User queryUserInfoById(Long id);

}
