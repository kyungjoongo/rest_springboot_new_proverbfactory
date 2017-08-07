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


@Controller
public class RestController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(RestController.class);

    @Autowired
    private RestDao testDao;

    @Autowired
    private RestDao restDao;
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "Z://upload_temp//";

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        // mav.addObject("message", "업로드성공!");
        mav.setViewName("redirect:" + "/test/list");
        return mav;
    }


    @RequestMapping("/rest/writeForm")
    public String writeForm() {

        return "rest/writeForm";
    }


    @RequestMapping("/rest/list")
    public ModelAndView list(Model model,
                             @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        ModelAndView mav = new ModelAndView();


        List<?> arrList = testDao.getList();

        mav.addObject("arrList", arrList);
        mav.setViewName("/rest/list");
        return mav;

    }


    @CrossOrigin
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/rest/getList")
    public @ResponseBody
    String getList() throws IOException {
        HashMap resultMap = new HashMap();
        List<?> arrList = testDao.getList();
        resultMap.put("arrList", arrList);
        return JSONValue.toJSONString(resultMap);

    }

    @PostMapping("/rest/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/rest/imageList";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            String fileName = file.getOriginalFilename();

            String[] fileExt = fileName.split("\\.");


            restDao.insertImage(file.getOriginalFilename(), fileExt[1]);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/rest/imageList";
    }

    @GetMapping("/rest/imageList")
    public ModelAndView uploadStatus() {
        ModelAndView mav = new ModelAndView();
        List arrList = restDao.getImageList();


        mav.addObject("arrList", arrList);
        mav.setViewName("/rest/imageList");
        return mav;

    }

    @RequestMapping(value = "/image/{imageName:.+}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        File serverFile = new File(UPLOADED_FOLDER + imageName);

        return Files.readAllBytes(serverFile.toPath());
    }


}
