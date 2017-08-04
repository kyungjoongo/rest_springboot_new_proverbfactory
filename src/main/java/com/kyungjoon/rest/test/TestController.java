package com.kyungjoon.rest.test;

import ch.qos.logback.classic.Logger;
import org.json.simple.JSONValue;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@Controller
public class TestController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestDao testDao;

   /* @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav=new ModelAndView();
        // mav.addObject("message", "업로드성공!");
        mav.setViewName("redirect:" + "/test/getList");
        return  mav;
    }*/


    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav=new ModelAndView();
        // mav.addObject("message", "업로드성공!");
        mav.setViewName("redirect:" + "/workquery/list");
        return  mav;
    }


    @RequestMapping("/test/list")
    public ModelAndView list(Model model,
                       @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        ModelAndView mav=new ModelAndView();


        List<?> arrList = testDao.getList();

        mav.addObject("arrList", arrList);

        mav.setViewName("/test/list");
        return  mav;

    }

   /* @RequestMapping("/")
    public String list(Model model,
                       @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        System.out.println("kdslgkdlfkgldfkglksdlfkgldfskg");

        return "/test/list";
    }*/

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/test/getList")
    public @ResponseBody
    String getList() throws IOException {
        HashMap resultMap = new HashMap();
        List<?> arrList = testDao.getList();
        resultMap.put("arrList", arrList);

        System.out.println("고경준 천재님이십니ㅏㄴㅇflsdkflskdflksdlkflsdkflksdlfk");

        return JSONValue.toJSONString(resultMap);

    }


}
