package com.feng.Controller;

import com.feng.Mybatis.mapper.blogsMapper;
import com.feng.Mybatis.pojo.MultiQury.rank;
import com.feng.Mybatis.pojo.blogs;
import com.feng.common.Result;
import com.feng.Mybatis.pojo.MultiQury.insertblog;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Controller
//把这个类加入容器中
@CrossOrigin
//允许跨域
@ResponseBody
//直接响应return 的东西
public class BlogController {

    @Autowired
    //从容器中注入blogsMapper类
    private blogsMapper blogsMapper;

    @GetMapping("findblogs")
    private Result findAllBlogs(){

        return Result.build(blogsMapper.selectall(),200,"成功的号角");
    }

    @PostMapping("insertblog")
    private Result insertblog(@RequestBody insertblog insertblog){
        blogs blogs=new blogs();
        //
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String id = request.getAttribute("ID").toString();
        //过滤器中解析token拿到用户的id，然后通过request请求域 把id传到controller（也就是这里）

        blogs.setAuthor_id(Integer.valueOf(id));
        blogs.setHead(insertblog.getHead());
        blogs.setContent(insertblog.getContent());

        int insert = blogsMapper.insert(blogs);
        //插入成功会返回1
        if (insert==1){
            return Result.ok(null);
        }
        else
            return Result.build(null,201,"不知道为啥添加失败");
    }

    @GetMapping("rank")
    private Result rank(){
        List<rank> rank = blogsMapper.rank();
        return Result.ok(rank);
    }
}
