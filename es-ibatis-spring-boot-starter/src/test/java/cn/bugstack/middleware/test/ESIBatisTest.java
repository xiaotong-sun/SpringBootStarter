package cn.bugstack.middleware.test;

import cn.bugstack.middleware.es.autoconfigure.ESIBatisProperties;
import cn.bugstack.middleware.es.ibatis.Resources;
import cn.bugstack.middleware.es.ibatis.SqlSession;
import cn.bugstack.middleware.es.ibatis.SqlSessionFactory;
import cn.bugstack.middleware.es.ibatis.SqlSessionFactoryBuilder;
import cn.bugstack.middleware.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.Reader;

public class ESIBatisTest {

    @Test
    public void test_queryUserInfoByName() {
        ESIBatisProperties esiBatisProperties = new ESIBatisProperties();
        esiBatisProperties.setAddress("jdbc:es://http://127.0.0.1:9200");
        esiBatisProperties.setMappers("mapper/User_Mapper.xml");
        try {
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(esiBatisProperties);

            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne("cn.bugstack.middleware.test.dao.IUserDao.queryUserInfoByName", "张飞");
                System.out.println(JSON.toJSONString(user));
            } finally {
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
