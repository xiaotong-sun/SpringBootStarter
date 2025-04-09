package org.elasticsearch.xpack.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class ApiTest {

    public static void main(String[] args) throws Exception {
        String address = "jdbc:es://http://127.0.0.1:9200";
        Properties connectionProperties = new Properties();
        try {
            Connection connection = DriverManager.getConnection(address, connectionProperties);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT name,occupation FROM bugstack");
            while (results.next()) {
                System.out.println(results.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
