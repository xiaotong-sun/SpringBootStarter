package cn.bugstack.middleware.rpc.network.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 小傅哥
 */
public class SyncWriteMap {

    public static Map<String, WriteFuture> syncKey = new ConcurrentHashMap<String, WriteFuture>();

}
