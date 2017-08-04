package com.kyungjoon.rest.test;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/test")
public class TestController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TestController.class);


    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        return "/test/list";
    }


}
