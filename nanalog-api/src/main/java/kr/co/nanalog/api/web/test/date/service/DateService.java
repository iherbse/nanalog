package kr.co.nanalog.api.web.test.date.service;

import kr.co.nanalog.api.web.test.date.model.request.DateRequest;
import kr.co.nanalog.api.web.test.date.model.request.YearAgoDateRequest;
import kr.co.nanalog.api.web.test.date.model.response.DateResponse;


public interface DateService {

    public DateResponse getCurrent(DateRequest dateRequest);

    public DateResponse getYearAgoDate(YearAgoDateRequest dateRequest);
}
