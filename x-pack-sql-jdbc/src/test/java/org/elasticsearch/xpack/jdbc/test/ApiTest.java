package org.elasticsearch.xpack.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

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
