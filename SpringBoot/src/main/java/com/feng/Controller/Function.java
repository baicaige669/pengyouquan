package com.feng.Controller;

import com.feng.Mybatis.mapper.BaseuserMapper;
import com.feng.Mybatis.mapper.blogsMapper;
import com.feng.Mybatis.pojo.blogs;
import com.feng.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin
@Controller
@ResponseBody
//一样的东西不再赘述
public class Function {

@Autowired
    private BaseuserMapper baseuserMapper;
@Autowired
private blogsMapper blogsMapper;

    @RequestMapping("findPage")
    //分页查询 传入‘当前页’和‘一页几条’
    Result findPage(Integer PageNum, Integer PageSize){
        Map<String, Object> result=new HashMap();
        result.put("total",baseuserMapper.selectAll());
        //查询总共多少条信息
        result.put("data",baseuserMapper.findPage(PageNum,PageSize));
        //查询当前页
        Result<Map<String, Object>> ok = Result.ok(result);
        //两个拆寻一起放入map中返回
        return ok;
    }

    @GetMapping("selectall")
    int selectAll(){
        return baseuserMapper.selectAll();
    }

    @GetMapping("key")
    //key是生成随机美文句子的api，key用于管理api接口
    Result key(){
        blogs findkey = blogsMapper.findkey();
        return Result.ok(findkey);
    }

    @GetMapping("updatekey")
    //修改外来接口信息
    Result key(String url,String key){
        blogs blogs = new blogs();
        blogs.setId(0);
        //为了方便，直接把数据库一个id为0的一条信息用于存储api信息
        blogs.setHead(url);
        blogs.setContent(key);
        int i = blogsMapper.updateByPrimaryKeySelective(blogs);
        return Result.build(null,200,"修改成功");
    }

}
