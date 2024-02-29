package com.feng.Mybatis.pojo.MultiQury;

import lombok.Data;

/**
 * 多表查询用户和用户的头像信息
 */
@Data
public class UserMore {
    private  int id;
    private String username;
    private String password;
    private String nickname;
    private String url;
    private String createtime;
}
