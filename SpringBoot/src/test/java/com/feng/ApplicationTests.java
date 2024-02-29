package com.feng;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {

        for (int i = 0; i < 40; i++) {
            int num = (int)(Math.random()*10) + 1;
            System.out.println(num);
        }
    }

}
