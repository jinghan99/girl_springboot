package com.yf.web;

import com.yf.GirlWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 *@Params: 单元测试
 *@Date: 2018/5/3 16:12
 *@Author: jinghan
 */ 
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE, classes = GirlWebApplication.class)
public class GirlWebApplicationTests {

    @Test
    public void test(){
        System.out.println("***************");
    }

}
