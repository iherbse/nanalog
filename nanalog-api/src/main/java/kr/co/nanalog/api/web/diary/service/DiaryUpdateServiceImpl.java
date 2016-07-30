package kr.co.nanalog.api.web.diary.service;

import kr.co.nanalog.api.entity.Component;
import kr.co.nanalog.api.entity.Page;
import kr.co.nanalog.api.repository.ComponentRepository;
import kr.co.nanalog.api.repository.PageRepository;
import kr.co.nanalog.api.web.diary.model.request.DiaryPageUpdateRequest;
import kr.co.nanalog.api.web.diary.model.request.DiaryUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by choijinjoo on 2016. 7. 30..
 */
@Service
@Transactional
public class DiaryUpdateServiceImpl implements DiaryUpdateService {
    //@Autowired
  //  DiaryRepository diaryRepository;
    @Autowired
    PageRepository pageRepository;
    @Autowired
    ComponentRepository componentRepository;

    @Override
    public Integer updateDiary(DiaryUpdateRequest diaryUpdateRequest) {
//        Diary diary = diaryRepository.findByDiaryId(diaryUpdateRequest.getDiaryId());
//
//        if (diary == null) {
//            return 0;
//        }
//
//        diary.setDiaryOption(diary.getDiaryOption());
//        diaryRepository.save(diary);

        return 1;
    }

    //FIXME code review 필요!!

    @Override
    public Integer updatePage(DiaryPageUpdateRequest diaryPageUpdateRequest) {
        Page page = pageRepository.findByPageId(diaryPageUpdateRequest.getPageId());
        ArrayList<Component> components = componentRepository.getComponentsByPageId(page.getPageId());
        ArrayList<Component> updatedComponents = diaryPageUpdateRequest.getComponents();
        ArrayList<Component> deletedComponents = new ArrayList<>();

        if (page == null) {
            return 0;
        }
        // delete될 컴포넌트 find
        for (Component component : components) {
            for (int i = 0; i < updatedComponents.size(); i++) {
                Component updatedComponent = updatedComponents.get(i);
                if (!component.getComponentId().equals(updatedComponent.getComponentId())) {
                    if (i == updatedComponents.size() - 1) {
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
        for (Component updatedComponent : updatedComponents) {
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

        page.setModifiedDate(new Date());
        pageRepository.save(page);


        return 1;
    }
}
