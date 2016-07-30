package kr.co.nanalog.api.web.test.date.controller;

import kr.co.nanalog.api.web.test.date.model.request.DateRequest;
import kr.co.nanalog.api.web.test.date.model.request.YearAgoDateRequest;
import kr.co.nanalog.api.web.test.date.model.response.DateResponse;
import kr.co.nanalog.api.web.test.date.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@RestController
@RequestMapping("/v1/test/date")
public class DateController {
    @Autowired
    private DateService dateService;

    /*

        # 파라미터 추가하고 랑 리턴 리스폰스 형태 수정
           - 조건에 의한 Date 값 반환(년을 받을지 월을 받을지 일을 받을지 시간을 받을지 // 마이크로초로 받을지 등등)
           - 예를들면.. 현재 시간 반환 시 어떠한 포맷으로 할지?
           - 리턴이 이렇게 생겼는데 저 date를 좀더 표준화된 방법으로 리턴하거나(마이크로초같은거
              아니면 년월일을 필드별로 분리해서 리턴하거나.. 뭐 기타등등 생각하기 나름인듯
            {
                  "date": "2016-07-17T18:13:15.750+09:00",
                  "code": 1
             }

     */
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public DateResponse getCurrentDate(@Valid DateRequest dateRequest) {

        DateResponse dateResponse = dateService.getCurrent(dateRequest);
        if (dateResponse.getCode() == 1) return dateResponse;
        else {
            dateResponse.setCode(-1);
            return dateResponse;
        }
    }

    @RequestMapping(value = "/yearago", method = RequestMethod.GET)
    public DateResponse getYearAgoDate(@Valid YearAgoDateRequest dateRequest) {

        DateResponse dateResponse = dateService.getYearAgoDate(dateRequest);
        if (dateResponse.getCode() == 1) return dateResponse;
        else {
            dateResponse.setCode(-1);
            return dateResponse;
        }
    }

}