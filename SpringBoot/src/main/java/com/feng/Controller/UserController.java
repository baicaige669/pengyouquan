package com.feng.Controller;

import com.feng.Mybatis.mapper.BaseuserMapper;
import com.feng.Mybatis.pojo.Baseuser;
import com.feng.Mybatis.pojo.MultiQury.UserMore;
import com.feng.Utils.JwtUtil;
import com.feng.common.Result;
import com.feng.common.ResultCodeEnum;
import com.feng.Mybatis.pojo.MultiQury.RegistUser;
import com.feng.Mybatis.pojo.MultiQury.LoginUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@CrossOrigin
@ResponseBody
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BaseuserMapper baseuserMapper;
    @GetMapping("update")
    Result updateByPrimaryKeySelective(String nickname){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String id = request.getAttribute("ID").toString();
       Baseuser baseuser=new Baseuser();
       baseuser.setId(Integer.valueOf(id));
       baseuser.setNickname(nickname);

       if (baseuserMapper.updateByPrimaryKeySelective(baseuser)==1){
       return Result.ok(null);
       }
       else {
           return Result.build(null,503,"不知道什么问题");
       }
    }

    @GetMapping("findall")
    List<Baseuser> findall(){
       return baseuserMapper.findall();
    }


    @PostMapping("login")
    Result login(@RequestBody LoginUser test){
       Result result=new Result();
       Baseuser baseuser=baseuserMapper.findByUsername(test.getUsername());
       if (baseuser==null){
           System.out.println("用户不存在");
           return Result.build("用户不存在", 503,"用户名不存在");
       }
       else {
           UserMore userMore = baseuserMapper.findUserMore(baseuser.getId().toString());
           if (test.getPassword().equals(userMore.getPassword()))
           return Result.build(userMore,200, JwtUtil.genToken(String.valueOf(userMore.getId())));
           else
               return Result.build(null,503,"密码错误了");

       }
    }
    @PostMapping("regist")
    Result regist(@RequestBody RegistUser registUser){
        Baseuser baseuser = new Baseuser();
        baseuser.setUsername(registUser.getUsername());
        baseuser.setPassword(registUser.getPassword());
        baseuser.setNickname(registUser.getNickname());
        int num = (int)(Math.random()*10) + 1;
        baseuser.setPhone(String.valueOf(num));
        int insert = baseuserMapper.insert(baseuser);
        if(insert==1)
            return Result.ok("恭喜注册成功");
        else
            return Result.build("不是吧，未知错误",ResultCodeEnum.PASSWORD_ERROR);
    }

    @GetMapping("checkusername")
    Result checkusername(String username){
        Baseuser baseuser = baseuserMapper.findByUsername(username);
        if (baseuser==null){
            Result<String> result = Result.ok("");
            result.setMessage("允许启动");
            return result;
        }
        else {
            return Result.build(null,503,"用户名占用");
        }
    }

    @GetMapping("findmore")
    Result findmore(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object id = request.getAttribute("ID");
        //过滤器中通过token查询用户id，并存储在request域中，此处是获取request域中的id
        UserMore userMore = baseuserMapper.findUserMore(id.toString());
        return Result.ok(userMore);
    }

    @GetMapping("updateP")
    //修改用户头像
    Result updateP(String phone){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object id = request.getAttribute("ID");
        //过滤器中通过token查询用户id，并存储在request域中，此处是获取request域中的id
        Baseuser baseuser = new Baseuser();
        baseuser.setId(Integer.valueOf(id.toString()));
        baseuser.setPhone(phone);
        baseuserMapper.updateByPrimaryKeySelective(baseuser);
        return Result.ok(null);
    }

}
