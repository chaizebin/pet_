package com.jk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public static void main(String[] args) {
        Long round  = null;
        for (int i = 0 ; i < 6 ; i++){
        Long v = Math.round((Math.random()) * 33);
            round = Math.round((Math.random() + 1) * 9);
            System.out.print(v+"\t");
        }
        System.out.println(round);
    }

}
