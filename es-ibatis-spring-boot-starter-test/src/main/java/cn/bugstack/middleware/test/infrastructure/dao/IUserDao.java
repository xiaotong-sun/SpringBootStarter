package cn.bugstack.middleware.test.infrastructure.dao;

import cn.bugstack.middleware.test.infrastructure.po.User;

public interface IUserDao {

     User queryUserInfoById(Long id);

}
