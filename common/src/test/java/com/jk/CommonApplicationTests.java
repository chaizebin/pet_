package com.jk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public static void main(String[] args) {
        for (int i = 0;i < 6;i++){
            double ceil = Math.ceil(Math.random()*33);
            System.out.print(ceil+"\t");
        }
        System.out.println( Math.ceil(Math.random()*16));
    }

}
