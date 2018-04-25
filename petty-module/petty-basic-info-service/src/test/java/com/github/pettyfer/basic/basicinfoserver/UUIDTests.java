package com.github.pettyfer.basic.basicinfoserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * @author Petty
 * @date 2018/4/25
 */

@RunWith(JUnit4.class)
@SpringBootTest
public class UUIDTests {

    @Test
    public void createUUID(){
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}
