package cn.bugstack.middleware.test;

import org.junit.Test;

import java.util.Random;

/**
 *
 * -javaagent:E:\itstack\git\MiddlewareDesign\CodeProbe\target\CodeProbe.jar=cn.bugstack.middleware.test
 */
public class ApiTest {

    public String queryUserInfo(String uid, String token) throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
        return "德莱联盟，王牌工程师，申请出栈！";
    }

    public static void main(String[] args) throws InterruptedException {
        String res = new ApiTest().queryUserInfo("100001", "LikdlNL13423");
        System.out.println(res);
    }

}
