package kr.co.nanalog.api.web.util.service;


import kr.co.nanalog.api.web.util.model.request.DateRequest;
import kr.co.nanalog.api.web.util.model.request.YearAgoDateRequest;
import kr.co.nanalog.api.web.util.model.respnose.DateResponse;

public interface DateService {

    public DateResponse getCurrent(DateRequest dateRequest);

    public DateResponse getYearAgoDate(YearAgoDateRequest dateRequest);
}
