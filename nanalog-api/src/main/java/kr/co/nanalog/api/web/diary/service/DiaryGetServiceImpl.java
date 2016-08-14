package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.entity.Component;
import kr.co.nanalog.api.web.diary.model.entity.Page;
import kr.co.nanalog.api.web.diary.model.request.DiaryPreviewRequest;
import kr.co.nanalog.api.web.diary.model.response.*;
import kr.co.nanalog.api.web.diary.repository.ComponentRepository;
import kr.co.nanalog.api.web.diary.repository.PageRepository;
import kr.co.nanalog.api.web.diary.model.request.DiaryComponentGetRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageGetRequest;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lcw on 7/26/16.
 */
@Service
@Transactional
public class DiaryGetServiceImpl implements DiaryGetService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private ComponentRepository componentRepository;

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
}
