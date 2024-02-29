package com.feng.Mybatis.pojo.MultiQury;

import lombok.Data;

/**
 * 查询用户发帖数量 用于排行榜的数据
 */
@Data
public class rank {
    private String author_id;
    private String username;
    private String nickname;
    private String NUMBER;
    private String url;
}
