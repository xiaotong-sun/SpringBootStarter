package cn.bugstack.middleware.test;

import java.util.logging.Logger;

/**
 * -agentpath:E:\itstack\git\github.com\itstack-jvmti\cmake-build-debug\libitstack_jvmti.dll
 */
public class TestLocationException {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("TestLocationException");
        try {
            PartnerEggResourceImpl resource = new PartnerEggResourceImpl();
            Object obj = resource.queryUserInfoById(null);
            logger.info("测试结果：" + obj);
        } catch (Exception e) {
            //屏蔽异常
        }
    }

    static class PartnerEggResourceImpl {
        Logger logger = Logger.getLogger("PartnerEggResourceImpl");

        public Object queryUserInfoById(String userId) {
            logger.info("根据用户Id获取用户信息" + userId);
            if (null == userId) {
                throw new NullPointerException("根据用户Id获取用户信息，空指针异常");
            }
            return userId;
        }
    }

}

