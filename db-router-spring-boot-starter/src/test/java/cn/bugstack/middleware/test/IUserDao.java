package cn.bugstack.middleware.test;

import cn.bugstack.middleware.db.router.annotation.DBRouter;

public interface IUserDao {

    @DBRouter(key = "userId")
    void insertUser(String req);

}
