package com.kyungjoon.rest.rest;

import ch.qos.logback.classic.Logger;
import org.json.simple.JSONValue;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


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





}
