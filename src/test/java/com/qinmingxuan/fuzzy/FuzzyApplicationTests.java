package com.qinmingxuan.fuzzy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FuzzyApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Math.sqrt((1/4) * (0 + 0 + (-0.643) * (-0.643) + 0.643 * 0.643)));
    }

}
