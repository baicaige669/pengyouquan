package com.feng.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.feng.Exception.TokenException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import com.feng.common.Result;

public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String token=request.getHeader("token");
        //判断请求头部是否携带了token
        if(!(handler instanceof HandlerMethod)){
            //如果不是handler（controller）请求 直接返回true 应该是防止请求静态资源之类的被拦截
            return true;
        }

        if(StrUtil.isBlank(token)){
            throw new TokenException();
            //如果token为空抛出异常

        }

        String userID;
        userID= JWT.decode(token).getAudience().get(0);
        //获取token中存储的userId
        request.setAttribute("ID",userID);
        //把id放到request请求域中，方便controller层获取用户id
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256("fengyizhou")).build();
        //解密

        try{
            jwtVerifier.verify(token);
            //解密失败抛出异常
        }catch (Exception e){
            throw new TokenException(e.getMessage());
        }

        return true;
    }
}
