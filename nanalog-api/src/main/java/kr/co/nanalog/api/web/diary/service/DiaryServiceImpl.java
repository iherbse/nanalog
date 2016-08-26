package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.request.DiaryCreateRequest;
import kr.co.nanalog.api.web.diary.model.entity.Component;
import kr.co.nanalog.api.web.diary.model.entity.Page;
import kr.co.nanalog.api.web.diary.model.request.*;
import kr.co.nanalog.api.web.diary.model.response.*;
import kr.co.nanalog.api.web.diary.repository.ComponentRepository;
import kr.co.nanalog.api.web.diary.repository.PageRepository;
import kr.co.nanalog.api.web.user.model.entity.User;
import kr.co.nanalog.api.web.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 1002731 on 2016. 8. 22..
 * Email : eenan@sk.com
 */
@Service
@Transactional
public class DiaryServiceImpl implements DiaryService{

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


    @Override
    public DiaryPageGetResponse getDiaryPages(DiaryPageGetRequest diaryPageGetRequest) {

        List<Page> pages = pageRepository.getPagesByUid(diaryPageGetRequest.getUid());

        DiaryPageGetResponseModel diaryPageGetResponseModel = new DiaryPageGetResponseModel();
        DiaryPageGetResponse diaryPageGetResponse = new DiaryPageGetResponse();
        diaryPageGetResponse.setDiaryPageGetResponseModels(new ArrayList());

        for (Page page :
                pages) {
            diaryPageGetResponseModel.setPageId(page.getPageId());
            diaryPageGetResponseModel.setCreatedDate(page.getCreatedDate());
            diaryPageGetResponseModel.setModifiedDate(page.getModifiedDate());

            diaryPageGetResponse.getDiaryPageGetResponseModels().add(diaryPageGetResponseModel);
        }
        diaryPageGetResponse.setUid(diaryPageGetRequest.getUid());
        diaryPageGetResponse.setDate(diaryPageGetRequest.getDate());

        return diaryPageGetResponse;
    }

    @Override
    public DiaryComponentGetResponse getDiaryCompoents(DiaryComponentGetRequest diaryComponentGetRequest) {

        List<Component> components = componentRepository.getComponentsByPageId(Long.valueOf(diaryComponentGetRequest.getPageId()));

        DiaryComponentGetResponseModel diaryComponentGetResponseModel = new DiaryComponentGetResponseModel();
        DiaryComponentGetResponse diaryComponentGetResponse = new DiaryComponentGetResponse();
        diaryComponentGetResponse.setDiaryComponentGetResponseModels(new ArrayList());

        for (Component component :
                components) {
            diaryComponentGetResponseModel = new DiaryComponentGetResponseModel();
            diaryComponentGetResponseModel.setComponentId(component.getComponentId());
            diaryComponentGetResponseModel.setComponentType(component.getComponentType());
            diaryComponentGetResponseModel.setComponentPosition(component.getComponentPosition());
            diaryComponentGetResponseModel.setComponentData(component.getComponentData());

            diaryComponentGetResponse.getDiaryComponentGetResponseModels().add(diaryComponentGetResponseModel);
        }
        diaryComponentGetResponse.setUid(diaryComponentGetRequest.getUid());
        diaryComponentGetResponse.setPageId(Long.valueOf(diaryComponentGetRequest.getPageId()));

        return diaryComponentGetResponse;
    }

    @Override
    public List<DiaryPreviewResponse> getDiaryPreviewList(DiaryPreviewRequest diaryPreviewRequest) {
        String uid = diaryPreviewRequest.getUid();
        Integer startDate = Integer.valueOf(diaryPreviewRequest.getStartDate());
        Integer endDate = Integer.valueOf(diaryPreviewRequest.getEndDate());

        List<Page> pageList = this.pageRepository.findByUid(uid);

        List<DiaryPreviewResponse> diaryPreviewResponseList = new ArrayList<>();
        for(Page page : pageList){
            Integer pageDate = Integer.valueOf(page.getCreatedDate());

            if(startDate <= pageDate && endDate >= pageDate){
                String uuid = page.getUid();
                String pid = String.valueOf(page.getPageId());
                String date = page.getCreatedDate();

                List<Component> componentList = this.componentRepository.findByPageId(Long.valueOf(pid));

                for (Component component : componentList) {

                    component.getComponentData();
                    String type = component.getComponentType().toString();
                    String title = component.getComponentData().substring(0, 10);
                    String body = component.getComponentData();

                    DiaryPreviewResponse diaryPreviewResponse = new DiaryPreviewResponse();
                    diaryPreviewResponse.setUid(uuid);
                    diaryPreviewResponse.setPid(pid);
                    diaryPreviewResponse.setDate(date);
                    diaryPreviewResponse.setType(type);
                    diaryPreviewResponse.setTitle(title);
                    diaryPreviewResponse.setBody(body);

                    diaryPreviewResponseList.add(diaryPreviewResponse);
                }
            }
        }

        return diaryPreviewResponseList;
    }

    @Override
    public Integer updateComponent(DiaryUpdateRequest diaryUpdateRequest) {
//        if (diaryUpdateRequest.getComponentId() == null || diaryUpdateRequest.getPageId() == null) {
//            return -1;
//        }
        Page page = pageRepository.findByPageId(diaryUpdateRequest.getPageId());

        if(page == null){
            return -1;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        page.setModifiedDate(format.format(new Date()));

        pageRepository.save(page);


        Component component = componentRepository.findByComponentId(diaryUpdateRequest.getComponentId());
        if(component == null){
            return -1;
        }
        component.setComponentPosition(diaryUpdateRequest.getComponentPosition());
        component.setComponentData(diaryUpdateRequest.getComponentData());

        componentRepository.save(component);


        return 1;
    }

    @Override
    public Integer updateDiary(List<DiaryUpdateRequest> diaryUpdateRequest) {
        Page page = pageRepository.findByPageId(diaryUpdateRequest.get(0).getPageId());
        ArrayList<Component> components = componentRepository.getComponentsByPageId(page.getPageId());
        // ArrayList<Component> updatedComponents = diaryUpdateRequest.getComponents();
        ArrayList<Component> deletedComponents = new ArrayList<>();

        if (page == null) {
            return -1;
        }
        // delete될 컴포넌트 find
        for (Component component : components) {
            for (int i = 0; i < diaryUpdateRequest.size(); i++) {
                DiaryUpdateRequest updatedComponent = diaryUpdateRequest.get(i);
                if (!component.getComponentId().equals(updatedComponent.getComponentId())) {
                    if (i == diaryUpdateRequest.size() - 1) {
                        deletedComponents.add(component);
                    }
                    continue;
                } else {
                    break;
                }
            }
        }
        //delete component
        if (deletedComponents.size() > 0) {
            for (Component deletedComponent : deletedComponents) {
                //componentRepository.deleteComponentByComponentId(deletedComponent.getComponentId());
            }
        }
        // update or create
        for (DiaryUpdateRequest updatedComponent : diaryUpdateRequest) {
            Component component = componentRepository.findByComponentId(updatedComponent.getComponentId());
            //create
            if (component == null) {
                // componentRepository.create(updatedComponent);
            } else { //update
                component.setComponentPosition(updatedComponent.getComponentPosition());
                component.setComponentData(updatedComponent.getComponentData());
                componentRepository.save(component);
            }
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        page.setModifiedDate(format.format(new Date()));
        pageRepository.save(page);

        return 1;
    }

    @Override
    public Integer deletePage(DiaryPageDeleteRequest diaryPageDeleteRequest){

        String userId = diaryPageDeleteRequest.getUserId();
        Long deletePageId = diaryPageDeleteRequest.getDeletePageId();

        Page page = this.pageRepository.findByPageId(deletePageId);


        if(userId.equals(page.getUid()))
        {

        }

        ArrayList<Component> components = componentRepository.getComponentsByPageId(deletePageId);


        if(components.size() == 0 || page == null){
            return -1;
        }

        this.componentRepository.deleteComponentBypageId(deletePageId);
        this.pageRepository.deleteBypageId(deletePageId);

        return 1;
    }

    @Override
    public Integer deleteComponent(ComponentDeleteRequest componentDeleteRequest){
        String userId = componentDeleteRequest.getUserId();
        Long deleteComponentId = componentDeleteRequest.getComponentId();

        Component component = componentRepository.getComponentByComponentId(deleteComponentId);
        Page page = this.pageRepository.findByPageId(component.getPageId());

        if(userId.equals(page.getUid())){

        }


        if(component == null){
            return -1;
        }

        this.componentRepository.delete(deleteComponentId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        page.setModifiedDate(format.format(new Date()));

        return 1;
    }

    @Override
    public Integer deleteUser(DiaryUserDeleteRequest diaryUserDeleteRequest){
        String uid = diaryUserDeleteRequest.getUid();
        List<Page> pageArrayList = this.pageRepository.findByUid(uid);

        this.pageRepository.deleteByUid(uid);

        for(int i=0; i<pageArrayList.size();i++){
            Page page = pageArrayList.get(i);
            this.componentRepository.deleteComponentBypageId(page.getPageId());
        }

        return 1;
    }
}
