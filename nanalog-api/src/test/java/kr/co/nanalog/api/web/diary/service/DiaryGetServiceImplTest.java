package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.repository.PageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by lcw on 7/31/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class DiaryGetServiceImplTest {

    @Mock
    private static PageRepository pageRepository;
    
    @Mock
    private static ComponentRepository componentRepository;

    @InjectMocks
    private static DiaryGetService diaryGetService = new DiaryGetServiceImpl();

    @Test
    public void getDiaryPages() throws Exception {
        System.out.println(getCurrentDate());
        Page page = new Page();
        page.setUid("test@test.com");
        page.setPageId(new Long(123131));
        page.setCreatedDate(Calendar.getInstance().getTime());
        page.setModifiedDate(new Date(1231));

        Mockito.when(pageRepository.save(page)).thenReturn(page);

        System.out.println(page.toString());
    }

    @Test
    public void getDiaryCompoents() throws Exception {
        System.out.println(getCurrentDate());
        Component component = new Component();
        component.setPageId(new Long(33333));
        component.setComponentId(new Long(22222));
        component.setComponentType(Component.ComponentType.IMAGE);
        component.setComponentPosition(Component.ComponentPosition.BOTTOM);
        component.setComponentData("asdiahsofhweoishfoiwehoih");

        Mockito.when(componentRepository.save(component)).thenReturn(component);

        System.out.println(component.toString());

    }

    private String getCurrentDate() {
        return LocalDateTime.now().plusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}