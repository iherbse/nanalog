package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.web.diary.model.entity.Component;
import kr.co.nanalog.api.web.diary.model.entity.Page;
import kr.co.nanalog.api.web.diary.repository.ComponentRepository;
import kr.co.nanalog.api.web.diary.repository.PageRepository;
import kr.co.nanalog.api.web.diary.model.request.DiaryComponentGetRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageGetRequest;
import kr.co.nanalog.api.web.diary.model.response.DiaryComponentGetResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryComponentGetResponseModel;
import kr.co.nanalog.api.web.diary.model.response.DiaryPageGetResponse;
import kr.co.nanalog.api.web.diary.model.response.DiaryPageGetResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        List<Component> components = componentRepository.getComponentsByPageId(diaryComponentGetRequest.getPageId());

        DiaryComponentGetResponseModel diaryComponentGetResponseModel = new DiaryComponentGetResponseModel();
        DiaryComponentGetResponse diaryComponentGetResponse = new DiaryComponentGetResponse();
        for (Component component :
                components) {
            diaryComponentGetResponseModel.setComponentId(component.getComponentId());
            diaryComponentGetResponseModel.setComponentType(component.getComponentType());
            diaryComponentGetResponseModel.setComponentPosition(component.getComponentPosition());
            diaryComponentGetResponseModel.setComponentData(component.getComponentData());

            diaryComponentGetResponse.getDiaryComponentGetResponseModels().add(diaryComponentGetResponseModel);
        }
        diaryComponentGetResponse.setUid(diaryComponentGetRequest.getUid());
        diaryComponentGetResponse.setPageId(diaryComponentGetRequest.getPageId());

        return diaryComponentGetResponse;
    }
}
