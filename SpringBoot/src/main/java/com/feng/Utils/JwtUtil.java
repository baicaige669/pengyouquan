package com.feng.Utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
/**
 * 用于生成token信息
 */
public class JwtUtil {

    public static String genToken(String userID){

        return JWT.create().withAudience(userID)
                .withExpiresAt(DateUtil.offsetMinute(new Date(),120))
                //120分钟过期 签名'fengyizhou',并且携带id信息
                .sign(Algorithm.HMAC256("fengyizhou"));
    }

}
