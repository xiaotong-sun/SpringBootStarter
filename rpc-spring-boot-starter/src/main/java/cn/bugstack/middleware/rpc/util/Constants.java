package cn.bugstack.middleware.rpc.util;

/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 小傅哥
 */
public class Constants {

    /**
     * 隐藏的key前缀，隐藏的key只能在filter里拿到，在RpcContext里拿不到，不过可以设置
     */
    public static final char HIDE_KEY_PREFIX = '.';

    /**
     * 内部使用的key前缀，防止和自定义key冲突
     */
    public static final char INTERNAL_KEY_PREFIX = '_';

}
