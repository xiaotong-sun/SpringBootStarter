package cn.bugstack.middleware.test.provider.interfaces;

import cn.bugstack.middleware.test.provider.export.HelloService;
import cn.bugstack.middleware.test.provider.export.domain.Hi;
import org.springframework.stereotype.Controller;

/**
 * 博  客：http://bugstack.cn
 * 公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 * create by 小傅哥
 */
@Controller("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String hi() {
        return "hi bugstack rpc";
    }

    @Override
    public String say(String str) {
        return str;
    }

    @Override
    public String sayHi(Hi hi) {
        return hi.getUserName() + " say：" + hi.getSayMsg();
    }

}
