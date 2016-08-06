package kr.co.nanalog.api.web.diary.controller;

import com.google.gson.Gson;
import kr.co.nanalog.NanalogApiApplication;
import kr.co.nanalog.api.web.diary.model.entity.Component;
import kr.co.nanalog.api.web.diary.model.entity.Page;
import kr.co.nanalog.api.web.diary.repository.ComponentRepository;
import kr.co.nanalog.api.web.diary.repository.PageRepository;
import kr.co.nanalog.api.web.diary.model.request.DiaryUpdateRequest;
import kr.co.nanalog.api.web.diary.service.DiaryGetService;
import kr.co.nanalog.api.web.diary.service.DiaryUpdateService;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NanalogApiApplication.class)
@WebAppConfiguration
public class DiaryUpdateControllerTest {

    @Autowired
    private WebApplicationContext context;
    @Autowired
    private DiaryUpdateService diaryUpdateService;
    @Autowired
    private DiaryGetService diaryGetService;
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ComponentRepository componentRepository;

    private MockMvc mockMvc;

    private static final Logger LOGGER = LoggerFactory.getLogger(DiaryUpdateControllerTest.class);

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


        //DiaryCreateService.createPage(page);
        //DiaryCreateService.createComponent(image);
        //DiaryCreateService.createComponent(sentence);
        //DiaryCreateService.createComponent(title);


    }

    @Test
    public void 페이지_업데이트_테스트() throws Exception {
        ArrayList<DiaryUpdateRequest> diaryUpdateRequests = new ArrayList<>();
        DiaryUpdateRequest diaryUpdateRequest = new DiaryUpdateRequest();
        diaryUpdateRequest.setPageId(new Long(1212));
        diaryUpdateRequest.setComponentId(new Long(222223));
        diaryUpdateRequest.setComponentPosition(Component.ComponentPosition.MID);
        diaryUpdateRequest.setComponentData("업데이트된 title");
        diaryUpdateRequests.add(diaryUpdateRequest);

        DiaryUpdateRequest diaryUpdateRequest2 = new DiaryUpdateRequest();
        diaryUpdateRequest2.setPageId(new Long(1212));
        diaryUpdateRequest2.setComponentId(new Long(2222210));
        diaryUpdateRequest2.setComponentPosition(Component.ComponentPosition.BOTTOM);
        diaryUpdateRequest2.setComponentData("추가된이미지");
        diaryUpdateRequests.add(diaryUpdateRequest2);


        Gson gson = new Gson();
        String json = gson.toJson(diaryUpdateRequests);

        mockMvc.perform(post("/v1/page/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }


    private String jsonStringFromObject(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}