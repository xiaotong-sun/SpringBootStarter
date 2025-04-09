itstack-demo-jvmti
====
背景描述：
JVMTI(JVM Tool Interface)位于jpda最底层，是Java虚拟机所提供的native编程接口。JVMTI可以提供性能分析、debug、内存管理、线程分析等功能。

环境准备：
1、Dev-C++
2、JetBrains CLion 2018.2.3
3、IntelliJ IDEA Community Edition 2018.3.1 x64
4、jdk1.8.0_45 64位
5、jvmti（在jdk安装目录下jdk1.8.0_45\include里，复制到和工程案例同层级目录下）

配置信息：（路径相关修改为自己的）
1、C++开发工具Clion配置
   1.1、配置位置；Settings->Build,Execution,Deployment->Toolchains
   1.2、MinGM配置：D:\Program Files (x86)\Dev-Cpp\MinGW64
2、java调试时配置
   2.1、配置位置：Run/Debug Configurations ->VM options
   2.2、配置内容：-agentpath:E:\itstack\GIT\itstack.org\jvmti-demo\itstack-demo-jvmti-location\cmake-build-debug\libitstack_demo_jvmti_location.dll

开发简述：
基于jvmti提供的接口服务，运用C++代码(win32-add_library)在Agent_OnLoad里开发监控服务，并生成dll文件。开发完成后在java代码中加入agentpath，这样就可以监控到我们需要的信息内容。

测试代码：
java http://source.jd.com/app/itstack-demo-jvmti.git
c++  http://source.jd.com/app/itstack-demo-jvmti-location.git

案例输出：
测试结果-定位类的签名：Lorg/itstack/demo/PartnerEggResourceImpl;
测试结果-定位方法信息：queryUserInfoById -> (Ljava/lang/String;)Ljava/lang/Object;
测试结果-定位方法位置：0 -> 43
测试结果-异常类的名称：Ljava/lang/NullPointerException;
测试结果-输出异常信息(可以分析行号)：
java.lang.NullPointerException: 根据用户Id获取用户信息，空指针异常
	at org.itstack.demo.PartnerEggResourceImpl.queryUserInfoById(TestLocationException.java:24)
	at org.itstack.demo.TestLocationException.main(TestLocationException.java:11)

其他文档：
1、jvmti api：https://docs.oracle.com/javase/8/docs/platform/jvmti/jvmti.html 