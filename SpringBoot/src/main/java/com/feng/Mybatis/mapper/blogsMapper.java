package com.feng.Mybatis.mapper;

import com.feng.Mybatis.pojo.MultiQury.BlogMore;
import com.feng.Mybatis.pojo.MultiQury.rank;
import com.feng.Mybatis.pojo.blogs;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
* @author 冯艺洲
* @description 针对表【blogs】的数据库操作Mapper
* @createDate 2024-02-07 19:39:28
* @Entity com.feng.Mybatis.pojo.blogs
*/
@Component
public interface blogsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(blogs record);

    int insertSelective(blogs record);

    blogs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(blogs record);

    int updateByPrimaryKey(blogs record);

    List<BlogMore> selectall();

    List<rank> rank();

    blogs findkey();

}
