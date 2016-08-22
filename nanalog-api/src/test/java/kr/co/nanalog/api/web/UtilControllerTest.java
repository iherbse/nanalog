package kr.co.nanalog.api.web;

import kr.co.nanalog.NanalogApiApplication;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 1002731 on 2016. 7. 31..
 * Email : eenan@sk.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NanalogApiApplication.class)
@WebAppConfiguration
public class UtilControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void 현재날씨() throws Exception {
        mockMvc.perform(get("/v1/util/weather")
                .param("city", "서울")
                .param("country", "강남구")
                .param("village", "도곡동"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 날짜테스트(){
        String startDate = getCurrentDate(1);
        String endDate = getCurrentDate(5);
        String currentDate = getCurrentDate(3);

        System.out.println(Integer.valueOf(startDate) < Integer.valueOf(currentDate));
    }

    private String getCurrentDate(int mon){
        return LocalDateTime.now().plusMonths(mon).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}