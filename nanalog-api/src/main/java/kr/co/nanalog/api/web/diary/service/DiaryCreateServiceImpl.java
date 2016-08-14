package kr.co.nanalog.api.web.diary.service;

import com.sun.tools.javac.comp.Todo;
import kr.co.nanalog.api.web.diary.model.DiaryCreateRequest;
import kr.co.nanalog.api.web.diary.model.entity.Component;
import kr.co.nanalog.api.web.diary.model.entity.Page;
import kr.co.nanalog.api.web.user.model.entity.User;
import kr.co.nanalog.api.web.diary.repository.ComponentRepository;
import kr.co.nanalog.api.web.diary.repository.PageRepository;
import kr.co.nanalog.api.web.user.repository.UserRepository;
import kr.co.nanalog.api.web.diary.model.request.ComponentCreateRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Created by JUNG on 2016. 7. 29..
 */
@Service
@Transactional
public class DiaryCreateServiceImpl implements DiaryCreateService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PageRepository pageRepository;
    @Autowired
    ComponentRepository componentRepository;

    @Override
    public Integer createPage(DiaryPageCreateRequest diaryPageCreateRequest) {

        User user = userRepository.findByUid(diaryPageCreateRequest.getUserId());
        Page page = pageRepository.findByPageId(diaryPageCreateRequest.getPageId());
        page.setCreatedDate(diaryPageCreateRequest.getCreatedDate());

        // 글을 먼저 쓰고 나중에 로그인을 하게 된다면???? userId는 로그인 user와는 상관이 없나?
        if(user.getUid() != page.getUid()) {
            return -1;
        }

        pageRepository.save(page);

        return 1;
    }

    @Override
    public Integer createComponent(ComponentCreateRequest componentCreateRequest) {

        if(componentCreateRequest.pageId == null) {
            return -1;
        }

        Component component = componentRepository.findByComponentId(componentCreateRequest.getComponentId());
        component.setComponentType(componentCreateRequest.getComponentType());
        component.setComponentPosition(componentCreateRequest.getComponentPosition());
        component.setComponentData(componentCreateRequest.getComponentDate());

        componentRepository.save(component);

        Page page = pageRepository.findByPageId(componentCreateRequest.getPageId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        page.setCreatedDate(format.format(new Date()));

        pageRepository.save(page);

        return 1;
    }

    @Override
    public Integer createDiary(DiaryCreateRequest diaryCreateRequest) {

        // 1. 이 유저가 오늘 다이어리 만들었나 봄
        String uid = diaryCreateRequest.getUid();
        String date = diaryCreateRequest.getDate();

        Page page = this.pageRepository.findByUidAndDate(uid, date);
        if(page == null){
            Page createPage = new Page();
            createPage.setUid(uid);
            createPage.setCreatedDate(getCurrentDate());
            createPage.setModifiedDate(getCurrentDate());
            this.pageRepository.save(createPage);
            page = this.pageRepository.findByUidAndDate(uid, date);
        }
        long pageId = page.getPageId();

        List<Component> componentList = this.componentRepository.findByPageId(pageId);
        if(componentList.size() > 5){
            return -1;
        }

        String type = diaryCreateRequest.getType();
        String data = diaryCreateRequest.getData();

        Component component = new Component();
        component.setPageId(pageId);
        if(type.equals(Component.ComponentType.TITLE)){
            component.setComponentType(Component.ComponentType.TITLE);
        }
        else if(type.equals(Component.ComponentType.IMAGE)){
            component.setComponentType(Component.ComponentType.IMAGE);
        }
        else{
            component.setComponentType(Component.ComponentType.SENTENCE);
        }
        // Todo 포지션 빠짐
        component.setComponentPosition(Component.ComponentPosition.MID);
        component.setComponentData(data);

        this.componentRepository.save(component);

        return 1;
    }

    private String getCurrentDate(){
        return LocalDateTime.now().plusMonths(0).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}