package com.hqzmss.controller;

import com.hqzmss.Test006SpringbootApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * 1、SpringBootTest注解能够加载Spring应用上下文
 * 2、WebAppConfiguration注解声明，由SpringJUnit4ClassRunner创建的应用程序上下文
 *    应该是一个WebApplicationContext
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Test006SpringbootApplication.class)
@WebAppConfiguration
public class LoginControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void indexPage() throws Exception {
        mockMvc.perform(get("/login/index"))
                .andExpect(status().isOk())                                     //测试接口返回的状态码
                .andExpect(view().name("login"));            //测试返回的视图名称
    }


}
