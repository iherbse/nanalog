package kr.co.nanalog.api.web.diary;

import kr.co.nanalog.NanalogApiApplication;
import kr.co.nanalog.api.web.common.domain.ApiResponseBody;
import kr.co.nanalog.api.web.diary.model.entity.Component;
import kr.co.nanalog.api.web.diary.model.entity.Page;
import kr.co.nanalog.api.web.diary.repository.ComponentRepository;
import kr.co.nanalog.api.web.diary.repository.PageRepository;
import kr.co.nanalog.api.web.diary.service.DiaryCreateService;
import kr.co.nanalog.api.web.user.model.entity.UserDeleteQueue;
import kr.co.nanalog.api.web.user.model.request.UserCreateRequest;
import kr.co.nanalog.api.web.user.repository.UserDeleteQueueRepository;
import kr.co.nanalog.api.web.user.repository.UserRepository;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
public class DiaryControllerTest {

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private DiaryCreateService diaryCreateService;
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ComponentRepository componentRepository;

    private MockMvc mockMvc;

    private static final Logger LOGGER = LoggerFactory.getLogger(DiaryControllerTest.class);

    private String uid;
    private String date;

    @Before
    public void setup() throws Exception {
        this.uid = "create@test.com";
        this.date = getCurrentDate();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        /*mockMvc.perform(post("/v1/diary/")
                .param("uid", this.uid)
                .param("date", this.date)
                .param("type", Component.ComponentType.SENTENCE.toString())
                .param("data", "원래 이런건 최대한 의미있는 값이 들어가면 좋음"))
                .andExpect(status().isOk())
                .andDo(print());*/
    }

    @Test
    public void 다이어리_첫번째_테스트() throws Exception {
        mockMvc.perform(post("/v1/diary/")
                .param("uid", this.uid)
                .param("date", this.date)
                .param("type", Component.ComponentType.SENTENCE.toString())
                .param("data", "원래 이런건 최대한 의미있는 값이 들어가면 좋음"))
                .andExpect(status().isOk())
                .andDo(print());

        mockMvc.perform(post("/v1/diary/")
                .param("uid", this.uid)
                .param("date", this.date)
                .param("type", Component.ComponentType.SENTENCE.toString())
                .param("data", "원래 이런건 최대한 의미있는 값이 들어가면 좋음"))
                .andExpect(status().isOk())
                .andDo(print());

        Page page = this.pageRepository.findByUidAndDate(this.uid, this.date);

        String pid = String.valueOf(page.getPageId());
        mockMvc.perform(get("/v1/diary/")
                .param("uid", this.uid)
                .param("date", this.date))
                .andExpect(status().isOk())
                .andDo(print());

        List<Component> componentList = this.componentRepository.findByPageId(page.getPageId());
        Long componentId = componentList.get(0).getComponentId();

        //update test
        mockMvc.perform(put("/v1/diary/component/")
                .param("pageId", pid)
                .param("componentId", String.valueOf(componentId))
                .param("componentData", "바뀐 데이터 !!!!"))
                .andExpect(status().isOk())
                .andDo(print());

        //delete test
        mockMvc.perform(delete("/v1/diary/component/")
                .param("userId", this.uid)
                .param("componentId", String.valueOf(componentId)))
                .andExpect(status().isOk())
                .andDo(print());

        mockMvc.perform(get("/v1/diary/page")
                .param("uid", this.uid)
                .param("pageId", pid))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 다이어리_두번째_테스트() throws Exception {
        mockMvc.perform(post("/v1/diary/")
                .param("uid", this.uid)
                .param("date", this.date)
                .param("type", Component.ComponentType.SENTENCE.toString())
                .param("data", "여기는 테스트 데이터"))
                .andExpect(status().isOk())
                .andDo(print());

        Page page = this.pageRepository.findByUidAndDate(this.uid, this.date);

        Long pid = page.getPageId();
        System.out.println("::pid::==> " + pid);
        mockMvc.perform(get("/v1/diary/page")
                .param("uid", this.uid)
                .param("pageId", String.valueOf(pid)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void 다이어리_preview_테스트() throws Exception {
        mockMvc.perform(post("/v1/diary/")
                .param("uid", this.uid)
                .param("date", this.date)
                .param("type", Component.ComponentType.SENTENCE.toString())
                .param("data", "원래 이런건 최대한 의미있는 값이 들어가면 좋음"))
                .andExpect(status().isOk())
                .andDo(print());

        mockMvc.perform(post("/v1/diary/")
                .param("uid", this.uid)
                .param("date", this.date)
                .param("type", Component.ComponentType.SENTENCE.toString())
                .param("data", "원래 이런건 최대한 의미있는 값이 들어가면 좋음"))
                .andExpect(status().isOk())
                .andDo(print());

        Page page = this.pageRepository.findByUidAndDate(this.uid, this.date);


        mockMvc.perform(get("/v1/diary/preview")
                .param("uid", this.uid)
                .param("startDate", "20160813")
                .param("endDate","20160920"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    private String getCurrentDate(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}