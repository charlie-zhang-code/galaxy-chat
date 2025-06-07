SET NAMES 'utf8mb4';

CREATE DATABASE IF NOT EXISTS galaxy_db;

use galaxy_db;

-- ----------------------------
-- 用户表
-- ----------------------------
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id         BIGINT(20)   NOT NULL COMMENT '用户唯一标识符，主键',
    username   VARCHAR(64)  NOT NULL COMMENT '用户登录时使用的用户名',
    password   VARCHAR(100) NOT NULL COMMENT '用户账户的密码，应存储加密后的值',
    nickname   VARCHAR(128) DEFAULT NULL COMMENT '用户在系统中显示的名字，可选',
    avatar     VARCHAR(255) DEFAULT NULL COMMENT '用户头像的URL或路径',
    background VARCHAR(255) DEFAULT NULL COMMENT '用户背景图片的URL或路径',
    quote      VARCHAR(255) DEFAULT NULL COMMENT '用户设置的个人座右铭或签名',
    gender     INT          DEFAULT 0 COMMENT '用户的性别，0表示保密，1表示男性，2表示女性',
    email      VARCHAR(128) DEFAULT NULL COMMENT '用户的电子邮件地址，可用于找回密码或接收通知',
    telephone  VARCHAR(20)  DEFAULT NULL COMMENT '用户的联系电话，可用于身份验证或联系用户',
    status     TINYINT(1)   DEFAULT 1 COMMENT '状态，0表示禁用，1表示正常启用',
    create_at  TIMESTAMP    DEFAULT NULL COMMENT '记录创建的时间戳',
    update_at  TIMESTAMP    DEFAULT NULL COMMENT '记录最后更新的时间戳',
    -- 添加索引
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
    COMMENT
        '用户表';

-- ----------------------------
-- 用户角色关联表 1-N角色
-- ----------------------------
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
    user_id BIGINT(20) NOT NULL COMMENT '用户ID',
    role_id BIGINT(20) NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
    COMMENT '用户角色关联表';

INSERT INTO sys_user_role(user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);

-- ----------------------------
-- 角色表
-- ----------------------------
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id        BIGINT(20) NOT NULL COMMENT '主键',
    name      VARCHAR(255) DEFAULT NULL COMMENT '角色名称',
    code      VARCHAR(50)  DEFAULT NULL COMMENT '角色编码，一旦创建后不允许修改',
    scope     INT          DEFAULT 0 COMMENT '角色权限范围，1全部数据权限 2自定数据权限 3本用户组数据权限 4本用户组及以下数据权限 5本人',
    status    TINYINT(1)   DEFAULT 1 COMMENT '状态，0表示禁用，1表示正常启用',
    create_at TIMESTAMP    DEFAULT NULL COMMENT '记录创建的时间戳',
    update_at TIMESTAMP    DEFAULT NULL COMMENT '记录最后更新的时间戳',
    -- 添加索引
    PRIMARY KEY (id),
    UNIQUE KEY uk_code (code)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
    COMMENT
        '角色表';

INSERT INTO sys_role(id, name, code, scope)
VALUES (1, '超级管理员', 'SUPER', 1),
       (2, '管理员', 'ADMIN', 4),
       (3, '普通用户', 'USER', 5);

-- ----------------------------
-- 用户-角色 关联表(1-N)
-- ----------------------------
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
    user_id BIGINT(20) NOT NULL COMMENT '用户ID',
    role_id BIGINT(20) NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
    COMMENT
        '用户-角色 关联表(1-N)';