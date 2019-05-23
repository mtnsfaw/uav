package com.chinasoftinternational.uav;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UavApplicationTests {

    @Test
    public void contextLoads() {

    }

    public static void main(String[] args) {
        String str = "^[A-Za-z0-9]+$";
        String test = "啊12plane1";
        System.out.println(test.matches(str));
    }

}
