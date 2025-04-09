package cn.bugstack.middleware.es.autoconfigure;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@ConfigurationProperties(prefix = ESIBatisProperties.MYBATIS_PREFIX)
public class ESIBatisProperties {

    public static final String MYBATIS_PREFIX = "es-ibatis";

    private String address;      // 链接地址 jdbc:es://http://127.0.0.1:9200
    private String basePackage;  // 扫描路径 cn.bugstack.middleware.test.infrastructure.dao
    private String mappers;      // Mapper 映射 mapper/User_Mapper.xml

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getMappers() {
        return mappers;
    }

    public void setMappers(String mappers) {
        this.mappers = mappers;
    }
}
