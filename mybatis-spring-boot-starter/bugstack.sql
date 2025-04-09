create database `bugstack`

CREATE TABLE
    USER
    (
        id bigint NOT NULL AUTO_INCREMENT COMMENT '自增ID',
        userId VARCHAR(9) COMMENT '用户ID',
        userNickName VARCHAR(32) COMMENT '用户昵称',
        userHead VARCHAR(16) COMMENT '用户头像',
        userPassword VARCHAR(64) COMMENT '用户密码',
        createTime DATETIME COMMENT '创建时间',
        updateTime DATETIME COMMENT '更新时间',
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8

insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (1, '184172133', '小傅哥', '01_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (2, '980765512', '铁锤', '02_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (3, '796542178', '团团', '03_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (4, '523088136', '哈尼克兔', '04_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (5, '123456001', '比丘卡', '05_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (6, '123456002', '兰兰', '06_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (7, '123456003', 'Alexa', '07_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (8, '123456004', '小白', '08_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (9, '123456005', '铃铛', '09_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (10, '123456006', '马小帅', '10_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (11, '123456007', 'S.A.K', '11_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
insert into user (id, userId, userNickName, userHead, userPassword, createTime, updateTime) values (12, '123456008', '池鱼有点贤', '12_50', '123456', '2020-01-01 00:00:00', '2020-01-01 00:00:00');
