package kr.co.nanalog.api.web;

import kr.co.nanalog.NanalogApiApplication;
import kr.co.nanalog.api.domain.ApiResponseBody;
import kr.co.nanalog.api.entity.UserDeleteQueue;
import kr.co.nanalog.api.repository.UserDeleteQueueRepository;
import kr.co.nanalog.api.repository.UserRepository;
import kr.co.nanalog.api.web.user.model.request.UserCreateRequest;
import kr.co.nanalog.api.web.user.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
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

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDeleteQueueRepository userDeleteQueueRepository;

    private MockMvc mockMvc;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUid("test@test.com");
        userCreateRequest.setName("TEST");
        userCreateRequest.setPassword("1234");
        userService.createUser(userCreateRequest);
    }

    @Test
    public void 사용자_회원가입_테스트() throws Exception {
        mockMvc.perform(post("/v1/user/")
                .param("uid", "create@test.com")
                .param("name", "CREATE")
                .param("password", "3434"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 사용자_정보수정_테스트() throws Exception {
        mockMvc.perform(put("/v1/user/")
                .param("uid", "test@test.com")
                .param("name", "MODIFY")
                .param("password", "1234"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 사용자_정보조회_테스트() throws Exception {
        mockMvc.perform(get("/v1/user/")
                .param("uid", "test@test.com"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 사용자_정보삭제_테스트() throws Exception {
        mockMvc.perform(delete("/v1/user/")
                .param("uid", "test@test.com")
                .param("password", "1234"))
                .andExpect(status().isOk())
                .andDo(print());

        UserDeleteQueue userDeleteQueue = userDeleteQueueRepository.findByUid("test@test.com");

        ApiResponseBody<UserDeleteQueue> apiResponseBody = new ApiResponseBody<UserDeleteQueue>(userDeleteQueue);
        mockMvc.perform(get("/v1/user/deactivation/")
                .param("uid", "test@test.com"))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonStringFromObject(apiResponseBody)))
                .andDo(print());
    }

    @Test
    public void 사용자_상태업데이트_테스트() throws Exception {
        mockMvc.perform(get("/v1/user/active/")
                .param("uid", "test@test.com"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    private String jsonStringFromObject(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}