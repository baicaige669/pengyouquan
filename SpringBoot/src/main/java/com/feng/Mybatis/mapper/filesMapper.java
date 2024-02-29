package com.feng.Mybatis.mapper;

import com.feng.Mybatis.pojo.files;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @author 冯艺洲
* @description 针对表【files】的数据库操作Mapper
* @createDate 2024-02-09 18:19:51
* @Entity com.feng.Mybatis.pojo.files
*/
@Component
public interface filesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(files record);

    int insertSelective(files record);

    files selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(files record);

    int updateByPrimaryKey(files record);

    List<files> findall();

}
