package cn.bugstack.middleware.test.provider.export;

import cn.bugstack.middleware.test.provider.export.domain.Hi;

public interface HelloService {

    String hi();

    String say(String str);

    String sayHi(Hi hi);

}
