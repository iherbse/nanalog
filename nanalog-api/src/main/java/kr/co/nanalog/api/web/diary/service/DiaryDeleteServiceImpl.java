package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.web.diary.model.request.ComponentDeleteRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageDeleteRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryUserDeleteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Leegain on 2016-07-27.
 */
@Service
@Transactional
public class DiaryDeleteServiceImpl implements DiaryDeleteService {
    @Autowired
    private PageRepository pageRepository;
    @Autowired
    private ComponentRepository componentRepository;



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

        this.componentRepository.deleteComponentByComponentId(deleteComponentId);
        page.setModifiedDate(new Date());

        return 1;
    }

    @Override
    public Integer deleteUser(DiaryUserDeleteRequest diaryUserDeleteRequest){
        String uid = diaryUserDeleteRequest.getUid();
        ArrayList<Page> pageArrayList = this.pageRepository.findByUid(uid);

        this.pageRepository.deleteByUid(uid);

        for(int i=0; i<pageArrayList.size();i++){
            Page page = pageArrayList.get(i);
            this.componentRepository.deleteComponentBypageId(page.getPageId());
        }

        return 1;
    }


}
