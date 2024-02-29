package com.feng.Mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName blogs
 */
@Data
public class blogs implements Serializable {
    private Integer id;

    private Integer author_id;

    private String head;

    private String content;

    private Date time;

    private static final long serialVersionUID = 1L;
}