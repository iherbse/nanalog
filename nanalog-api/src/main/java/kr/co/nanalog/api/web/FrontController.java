package kr.co.nanalog.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 1002731 on 2016. 7. 17..
 * Email : eenan@sk.com
 */
@RestController
@RequestMapping("/")
public class FrontController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrontController.class);

    public String test(){
        return "test";
    }
}