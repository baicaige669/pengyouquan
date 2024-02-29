package com.feng.Mybatis.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName files
 */
@Data
public class files implements Serializable {
    private Integer id;

    private String name;

    private String type;

    private Long size;

    private String url;

    private Integer isDele;

    private Integer enable;

    public files(){};
    public files(String name, String type, Long size, String url) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.url = url;
    }

    private static final long serialVersionUID = 1L;
}