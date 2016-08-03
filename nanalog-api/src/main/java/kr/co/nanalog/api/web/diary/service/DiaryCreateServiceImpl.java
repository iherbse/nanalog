package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.entity.User;
import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.repository.UserRepository;
import kr.co.nanalog.api.web.diary.model.request.ComponentCreateRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

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

}
