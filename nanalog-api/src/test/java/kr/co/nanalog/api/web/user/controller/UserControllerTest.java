package kr.co.nanalog.api.web.user.controller;

import kr.co.nanalog.NanalogApiApplication;
import kr.co.nanalog.api.web.user.model.request.UserCreateRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by 1002731 on 2016. 7. 25..
 * Email : eenan@sk.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NanalogApiApplication.class)
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void 사용자_회원가입_테스트() throws Exception {

        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUid("test@test.com");
        userCreateRequest.setName("테스트");
        userCreateRequest.setPassword("3434");

//        mockMvc.perform(post("/v1/user/", userCreateRequest)).andExpect(status().isOk());
    }
}