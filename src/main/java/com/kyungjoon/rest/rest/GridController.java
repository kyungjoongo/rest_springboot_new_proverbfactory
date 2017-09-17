package com.kyungjoon.rest.rest;

import ch.qos.logback.classic.Logger;
import org.json.simple.JSONValue;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@Controller
public class GridController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(GridController.class);

    @Autowired
    private RestDao testDao;

    @Autowired
    private RestDao restDao;


    @GetMapping("/grid/gridList")
    public ModelAndView gridList() {
        ModelAndView mav = new ModelAndView();
        HashMap resultMap = new HashMap();
        List<?> proverbList = testDao.getList();

        mav.addObject("proverbList", proverbList);
        mav.setViewName("/grid/gridList");
        return mav;

    }

    @CrossOrigin
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/grid/gridListJson")
    public @ResponseBody
    String getList() throws IOException {
        HashMap resultMap = new HashMap();
        List<?> arrList = testDao.getList();
        resultMap.put("arrList", arrList);
        return JSONValue.toJSONString(resultMap);

    }





}
