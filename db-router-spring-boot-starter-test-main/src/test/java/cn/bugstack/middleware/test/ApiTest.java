package cn.bugstack.middleware.test;

import cn.bugstack.middleware.test.infrastructure.dao.IUserDao;
import cn.bugstack.middleware.test.infrastructure.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    private IUserDao userDao;

    @Test
    public void test_queryUserInfoByUserId() {
        User user = userDao.queryUserInfoByUserId(new User("980765512"));
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

    @Test
    public void test_insertUser() {
        User user = new User();
        user.setUserId("980765512");
        user.setUserNickName("小傅哥");
        user.setUserHead("01_50");
        user.setUserPassword("123456");

        userDao.insertUser(user);
    }

}
