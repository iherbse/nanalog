package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.web.diary.model.request.ComponentDeleteRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryDeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by Leegain on 2016-07-27.
 */
public class DiaryDeleteServiceImpl implements DiaryDeleteService {
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ComponentRepository componentRepository;



    public Integer deleteDiary(DiaryDeleteRequest diaryDeleteRequest){

        String UserId = diaryDeleteRequest.getUserId();
        Long deletePageId = diaryDeleteRequest.getDeletePageId();

        ArrayList<Component> components = componentRepository.getComponentsByPageId(deletePageId);
        Page page = pageRepository.findByPageId(deletePageId);

        if(components.size() == 0)
            return -1;

        if(page == null)
            return -1;

        componentRepository.deleteComponentBypageId(deletePageId);

        pageRepository.deleteByPageId(deletePageId);


        return 1;
    }

    @Override
    public Integer deleteComponent(ComponentDeleteRequest componentDeleteRequest){
        String UserId = componentDeleteRequest.getUserId();
        Long deleteComponentId = componentDeleteRequest.getComponentId();

        Component component = componentRepository.getComponentByComponentId(deleteComponentId);

        if(component == null)
            return -1;

        componentRepository.deleteComponentByComponentId(deleteComponentId);

        return 1;
    }


}
