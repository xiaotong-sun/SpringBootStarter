# x-pack-sql-jdbc

x-pack-sql-jdbc ES jdbc

## 软件下载

- ES 7.10.2：[elasticsearch-7.10.2-darwin-x86_64.tar.gz MAC版本](https://download.csdn.net/download/qq_20051535/14934248)
- kibana：[kibana-7.10.2-darwin-x86_64.tar.gz MAC版本](https://download.csdn.net/download/qq_20051535/14935342)
- Kibana详细入门教程：[https://www.cnblogs.com/chenqionghe/p/12503181.html?utm_source=tuicool&utm_medium=referral](https://www.cnblogs.com/chenqionghe/p/12503181.html?utm_source=tuicool&utm_medium=referral)

## 试用方式

1. 启动 ES

```java
fuzhengweideMacBook-Pro:bin fuzhengwei$ cd /Users/fuzhengwei/itstack/soft/elasticsearch-7.10.2/bin
fuzhengweideMacBook-Pro:bin fuzhengwei$ ./elasticsearch
```

*也可以通过 bin 目录下的应用程序启动*

2. 启动 kibana

```java
fuzhengweideMacBook-Pro:bin fuzhengwei$ cd /Users/fuzhengwei/itstack/soft/kibana-7.10.2-darwin-x86_64
fuzhengweideMacBook-Pro:bin fuzhengwei$ ./kibana
```

## 试用期限

A&Q

- [current license is non-compliant for jdbc](https://blog.csdn.net/ctypyb2002/article/details/106115691)

**查看试用期**

```java
# curl -XGET http://localhost:9200/_license
{
  "license" : {
    "status" : "active",
    "uid" : "91546f48-bd7f-4a74-b4b9-889dece7db80",
    "type" : "basic",
    "issue_date" : "2020-05-12T20:10:42.742Z",
    "issue_date_in_millis" : 1589314242742,
    "max_nodes" : 1000,
    "issued_to" : "my-application",
    "issuer" : "elasticsearch",
    "start_date_in_millis" : -1
  }
}
```

**修改试用期**

```java
# curl -X POST "localhost:9200/_license/start_trial?acknowledge=true&pretty"
{
  "acknowledged" : true,
  "trial_was_started" : true,
  "type" : "trial"
}
```


