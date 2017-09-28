package com.kyungjoon.rest.receipe;

import ch.qos.logback.classic.Logger;
import com.kyungjoon.rest.rest.Constants;
import org.json.simple.JSONValue;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
public class ReceipeController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ReceipeController.class);

    @Autowired
    private ReceipeDao receipeDao;


    @CrossOrigin
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/receipe/receipeListToJson")
    public @ResponseBody
    String receipeListToJson() throws IOException {
        List<?> arrList = receipeDao.getList();
        return JSONValue.toJSONString(arrList);

    }


    @GetMapping("/receipe/write")
    public ModelAndView writeForm() {
        ModelAndView mav = new ModelAndView();
        HashMap resultMap = new HashMap();
        mav.setViewName("/receipe/write");
        return mav;

    }

    @PostMapping("/receipe/write")
    public String writePostAction(

            Receipe receipe,
            RedirectAttributes redirectAttributes

    ) {
        ModelAndView mav = new ModelAndView();


        System.out.println("result-->" + receipe.toString());


        //이미지 업로드 파일이 존재하지 않는 경우..
        if (receipe.getImage().isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/receipe/write";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = receipe.getImage().getBytes();
            Path path = Paths.get(Constants.RECEIPE_IMAGE_UPLOADED_FOLDER + receipe.getImage().getOriginalFilename());
            Files.write(path, bytes);

            String fileName = receipe.getImage().getOriginalFilename();
            String[] fileExt = fileName.split("\\.");

            /*receipeDao.insertReceipe(receipe.getImage().getOriginalFilename(), fileExt[1]);*/
            int result = receipeDao.insertReceipe(receipe);
            System.out.println("result222-->" + result);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + receipe.getImage().getOriginalFilename() + "'");


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/receipe/write";


    }



    /**
     * 레시피 리스팅
     * @return
     */
    @GetMapping("/receipe/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        List<Receipe> arrList = receipeDao.getList();


        System.out.println(arrList);

        mav.addObject("arrList", arrList);
        mav.setViewName("/receipe/list");
        return mav;

    }


    @RequestMapping(value = "/receipeImage/{imageName:.+}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        File serverFile = new File(Constants.RECEIPE_IMAGE_UPLOADED_FOLDER + imageName);

        return Files.readAllBytes(serverFile.toPath());
    }

}
