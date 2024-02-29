package com.feng.Mybatis.pojo.MultiQury;

import lombok.Data;
/**
 * 多表查询  博客  和  发表用户的信息
 */
@Data
public class BlogMore {
    private String userid;
    private String username;
    private String nickname;
    private String blogid;
    private String head;
    private String content;
    private String time;
    private String url;
    private int is_dele;
    private int enable;
}
