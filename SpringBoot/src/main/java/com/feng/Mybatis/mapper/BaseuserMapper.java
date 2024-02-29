package com.feng.Mybatis.mapper;

import com.feng.Mybatis.pojo.Baseuser;
import com.feng.Mybatis.pojo.MultiQury.UserMore;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
* @author 冯艺洲
 * Mapper接口
* @description 针对表【baseuser】的数据库操作Mapper
* @createDate 2024-01-30 10:12:10
* @Entity Mybatis.dao.Baseuser
*/
@Component
public interface BaseuserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Baseuser record);

    int insertSelective(Baseuser record);

    Baseuser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Baseuser record);

    int updateByPrimaryKey(Baseuser record);

    List<Baseuser> findall();

    List<Baseuser> findPage(@RequestParam Integer PageNum, @RequestParam Integer PageSize);

    int selectAll();

    Baseuser findByUsername(String username);

    UserMore findUserMore(String ID);

    int findnewurl(String id);
}
