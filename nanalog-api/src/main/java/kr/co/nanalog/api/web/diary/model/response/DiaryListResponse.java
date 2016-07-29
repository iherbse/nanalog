package kr.co.nanalog.api.web.diary.model.response;

import kr.co.nanalog.api.entity.Diary;
import kr.co.nanalog.api.entity.Page;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lcw on 7/26/16.
 */
public class DiaryListResponse {

    private ArrayList<Diary> diaries;
    private ArrayList<ArrayList<Page>> pages;
    private ArrayList<Integer> totalPagesOfDiaries;

    public DiaryListResponse() {
        diaries = new ArrayList<>();
        pages = new ArrayList<>();
        totalPagesOfDiaries = new ArrayList<>();
    }

    public ArrayList<Diary> getDiaries() {
        return diaries;
    }

    public void setDiaries(ArrayList<Diary> diaries) {
        this.diaries = diaries;
    }

    public ArrayList<ArrayList<Page>> getPages() {
        return pages;
    }

    public void setPages(ArrayList<ArrayList<Page>> pages) {
        this.pages = pages;
    }

    public ArrayList<Integer> getTotalPagesOfDiaries() {
        return totalPagesOfDiaries;
    }

    public void setTotalPagesOfDiaries(ArrayList<Integer> totalPagesOfDiaries) {
        this.totalPagesOfDiaries = totalPagesOfDiaries;
    }

    @Override
    public String toString() {
        return "DiaryListResponse{" +
                "diaries=" + diaries +
                ", pages=" + pages +
                ", totalPagesOfDiaries=" + totalPagesOfDiaries +
                '}';
    }
}
