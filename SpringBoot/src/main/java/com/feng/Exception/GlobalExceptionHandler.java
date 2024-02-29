package com.feng.Exception;

import com.feng.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler {
//全局异常处理类

    @ExceptionHandler(TokenException.class)
    //遇到TokenException.class类的异常都会跳转到此处
    @ResponseBody
    public Result handler(){
        return Result.build("",444,"token失效");
    }
    //解决方法
}
