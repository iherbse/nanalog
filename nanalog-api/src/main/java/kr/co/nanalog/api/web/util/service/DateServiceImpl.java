package kr.co.nanalog.api.web.util.service;

import kr.co.nanalog.api.web.util.model.request.DateRequest;
import kr.co.nanalog.api.web.util.model.request.YearAgoDateRequest;
import kr.co.nanalog.api.web.util.model.respnose.DateResponse;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;


@Service
public class DateServiceImpl implements DateService {

    @Override
    public DateResponse getCurrent(DateRequest dateRequest) {
        DateTime date = DateTime.now();

        return getDate(dateRequest, date);
    }

    @Override
    public DateResponse getYearAgoDate(YearAgoDateRequest dateRequest) {

        if(dateRequest.getDate() == null || dateRequest.getTo() == null){
            DateResponse dateResponse = new DateResponse();
            dateResponse.setCode(-1);
            return dateResponse;
        }
        DateTimeFormatter transFormat = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime date = transFormat.parseDateTime(dateRequest.getDate());
        date = date.minusYears(dateRequest.getTo());

        return getDate(dateRequest, date);
    }

    private DateResponse getDate(DateRequest dateRequest, DateTime date) {
        DateResponse dateResponse = new DateResponse();

        if (dateRequest.getFormatter() != null) {

            String formatter = dateRequest.getFormatter();
            DateTimeFormatter fmt = DateTimeFormat.forPattern(formatter);
            String str = date.toString(fmt);
            dateResponse.setFormattedDate(str);

        }
        if (dateRequest.getType() != null) {
            switch (dateRequest.getType()) {    //    YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, DATE;

                case 0:
                    dateResponse.setTypedDate(date.getYear());
                    dateResponse.setDateType(0);
                    break;
                case 1:
                    dateResponse.setTypedDate(date.getMonthOfYear());
                    dateResponse.setDateType(1);
                    break;
                case 2:
                    dateResponse.setTypedDate(date.getDayOfMonth());
                    dateResponse.setDateType(2);
                    break;
                case 3:
                    dateResponse.setTypedDate(date.getHourOfDay());
                    dateResponse.setDateType(3);
                    break;
                case 4:
                    dateResponse.setTypedDate(date.getMinuteOfHour());
                    dateResponse.setDateType(4);
                    break;
                case 5:
                    dateResponse.setTypedDate(date.getSecondOfMinute());
                    dateResponse.setDateType(5);
                    break;
                case 6:
                    dateResponse.setTypedDate(date.getDayOfWeek());
                    dateResponse.setDateType(6);
                    break;
            }
        }
        dateResponse.setCode(1);
        return dateResponse;
    }
}
