package kr.co.nanalog.api.web.diary.controller;

import com.google.gson.Gson;
import kr.co.nanalog.NanalogApiApplication;
import kr.co.nanalog.api.web.diary.model.entity.Component;
import kr.co.nanalog.api.web.diary.model.entity.Page;
import kr.co.nanalog.api.web.diary.repository.ComponentRepository;
import kr.co.nanalog.api.web.diary.repository.PageRepository;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageGetRequest;
import kr.co.nanalog.api.web.diary.service.DiaryGetService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by lcw on 7/31/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NanalogApiApplication.class)
@WebAppConfiguration
public class DiaryGetControllerTest {

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private DiaryGetService diaryGetService;
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ComponentRepository componentRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        Page page = new Page();
        page.setUid("test@test.com");
        page.setPageId(new Long(1212));
        page.setCreatedDate(Calendar.getInstance().getTime().toString());
        page.setModifiedDate((new Date(1231)).toString());

        Component image = new Component();
        image.setPageId(new Long(1212));
        image.setComponentId(new Long(222221));
        image.setComponentType(Component.ComponentType.IMAGE);
        image.setComponentPosition(Component.ComponentPosition.MID);
        image.setComponentData("image url");

        Component sentence = new Component();
        sentence.setPageId(new Long(1212));
        sentence.setComponentId(new Long(222222));
        sentence.setComponentType(Component.ComponentType.SENTENCE);
        sentence.setComponentPosition(Component.ComponentPosition.BOTTOM);
        sentence.setComponentData("setence!!");

        Component title = new Component();
        title.setPageId(new Long(1212));
        title.setComponentId(new Long(222223));
        title.setComponentType(Component.ComponentType.TITLE);
        title.setComponentPosition(Component.ComponentPosition.TOP);
        title.setComponentData("title!");
    }

    private MockMvc mockMvc;
    private static final Logger LOGGER = LoggerFactory.getLogger(DiaryUpdateControllerTest.class);

    @Test
    public void getDiaryPages() throws Exception {
        DiaryPageGetRequest diaryPageGetRequest = new DiaryPageGetRequest();
        diaryPageGetRequest.setUid("test@test.com");

        Gson gson = new Gson();
        String json = gson.toJson(diaryPageGetRequest);
        mockMvc.perform(get("/v1/diary").contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getPageComponents() throws Exception {

        mockMvc.perform(get("/v1/diary/page").param("uid","test@test.com")).andExpect(status().isOk()).andDo(print());
    }

    private String jsonStringFromObject(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}