package kr.co.nanalog.api.web.test.color.controller;

import kr.co.nanalog.api.web.test.color.model.request.RandomColorRequest;
import kr.co.nanalog.api.web.test.color.model.respnose.RandomColorResponse;
import kr.co.nanalog.api.web.test.color.service.RandomColorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by lcw on 7/17/16.
 */
@RestController
@RequestMapping("/v1/test/color")
public class RandomColorController {

   private RandomColorService randomColorService;

   private RandomColorResponse randomColorResponse;

   @RequestMapping(value = "/random",method = RequestMethod.GET)
   public RandomColorResponse choosenColor(@Valid RandomColorRequest randomColorRequest){

      randomColorService = new RandomColorService();

      randomColorResponse = randomColorService.chosenColor(randomColorRequest.getWantedColor());

      return randomColorResponse;
   }
}
