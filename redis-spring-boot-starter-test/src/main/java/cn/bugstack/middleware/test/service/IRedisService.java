package cn.bugstack.middleware.test.service;

import cn.bugstack.middleware.redis.annotation.XRedis;

@XRedis
public interface IRedisService {

    String get(String key);

    void set(String key, String val);

}
