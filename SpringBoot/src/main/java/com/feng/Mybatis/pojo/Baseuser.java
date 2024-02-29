package com.feng.Mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName baseuser
 */
@Data
public class Baseuser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String phone;

    private Date createtime;

    private static final long serialVersionUID = 1L;


}