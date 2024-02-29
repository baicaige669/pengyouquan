package com.feng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan
//不知道啥用 好像是扫描Mapper的
@SpringBootApplication
//启动类 程序的入口
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

//据说加上注释 不然以后看不懂自己的代码0.o 那就从这里开始把