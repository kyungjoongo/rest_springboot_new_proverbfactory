package com.kyungjoon.rest.rest;

import ch.qos.logback.classic.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


@Controller
public class LhController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(LhController.class);

    @Autowired
    private RestDao testDao;

    @Autowired
    private RestDao restDao;

    @GetMapping("/lh/lhList")
    public ModelAndView gridList(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") String pageIndex) {
        ModelAndView mav = new ModelAndView();
        HashMap resultMap = new HashMap();

        mav.addObject("pageIndex", pageIndex);
        mav.setViewName("/lh/lhList");
        return mav;

    }

    @CrossOrigin
    @PostMapping("/lh/lhListToJson")
    public @ResponseBody String lhList(
            @RequestParam(value = "pageIndex", required = false, defaultValue = "1") String pageIndex
            ,@RequestParam(value = "srchbrtcCode", required = false, defaultValue = "") String srchbrtcCode
            ,@RequestParam(value = "srchsignguCode", required = false, defaultValue = "") String srchsignguCode


    ) {
        ModelAndView mav = new ModelAndView();
        HashMap resultMap = new HashMap();

        String baseUrl = "";
        RestTemplate restTemplate = new RestTemplate();
        org.json.simple.JSONArray jsonArray=new JSONArray();

       /* if (srchbrtcCode.trim().equals(11) ){
            srchsignguCode= "680";
        }*/

        JSONObject jsonObj=new JSONObject();
        URI uri = URI.create("https://www.myhome.go.kr//hws/portal/sch/selectRsdtRcritNtcList.do?prgrStts=모집중&pageIndex="+pageIndex.trim()
                +  "&recordCountPerPage=20&pageSize=20&pageUnit=100&srchbrtcCode="+srchbrtcCode + "&srchsignguCode="+ srchsignguCode);
        String responseString = restTemplate.getForObject(uri, String.class);

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(responseString);
            jsonObj = (JSONObject) obj;

            /*jsonArray = (org.json.simple.JSONArray) jsonObj.get("resultList");
            Long resultCnt = (Long) jsonObj.get("resultCnt");*/
            //System.out.println("totlacnt-->"+ resultCnt);

        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonObj.toJSONString();

    }


    @CrossOrigin
    @RequestMapping("/lh/gettGooListToJson")
    public @ResponseBody String gettGooListToJson(
            @RequestParam(value = "pageIndex", required = false, defaultValue = "1") String pageIndex
            ,@RequestParam(value = "srchbrtcCode", required = false, defaultValue = "41") String srchbrtcCode //서울시 경기도 충청북도.

    ) {
        ModelAndView mav = new ModelAndView();
        HashMap resultMap = new HashMap();

        String baseUrl = "";
        RestTemplate restTemplate = new RestTemplate();
        org.json.simple.JSONArray jsonArray=new JSONArray();

        JSONObject jsonObj=new JSONObject();
        URI uri = URI.create("https://m.myhome.go.kr/hws/com/cde/selectBrtcSisngn.do?com_searchType=SIGNGU_CODE&com_brtcCode="+srchbrtcCode );
        String responseString = restTemplate.getForObject(uri, String.class);

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(responseString);
            jsonObj = (JSONObject) obj;

            /*jsonArray = (org.json.simple.JSONArray) jsonObj.get("resultList");
            Long resultCnt = (Long) jsonObj.get("resultCnt");*/
            //System.out.println("totlacnt-->"+ resultCnt);

        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonObj.toJSONString();

    }


    @CrossOrigin
    @RequestMapping("/lh/lhDetailToJson")
    public @ResponseBody String lhDetailToJson(
            @RequestParam(value = "pblancId", required = false, defaultValue = "2184") String pblancId

    ) {
        ModelAndView mav = new ModelAndView();
        HashMap resultMap = new HashMap();

        String baseUrl = "";
        RestTemplate restTemplate = new RestTemplate();
        org.json.simple.JSONArray jsonArray=new JSONArray();

        JSONObject jsonObj=new JSONObject();
        URI uri = URI.create("https://m.myhome.go.kr/hws/portal/sch/selectRcritBasicInfo.do?pblancId="+ pblancId);
        String responseString = restTemplate.getForObject(uri, String.class);

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(responseString);
            jsonObj = (JSONObject) obj;

            /*jsonArray = (org.json.simple.JSONArray) jsonObj.get("resultList");
            Long resultCnt = (Long) jsonObj.get("resultCnt");*/
            //System.out.println("totlacnt-->"+ resultCnt);

        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonObj.toJSONString();

    }

    @CrossOrigin
    @RequestMapping("/lh/suplyListToJson")
    public @ResponseBody String suplyListToJson (
            @RequestParam(value = "pblancId", required = false, defaultValue = "2184") String pblancId

    ) {
        ModelAndView mav = new ModelAndView();
        HashMap resultMap = new HashMap();

        String baseUrl = "";
        RestTemplate restTemplate = new RestTemplate();
        org.json.simple.JSONArray jsonArray=new JSONArray();

        JSONObject jsonObj=new JSONObject();
        URI uri = URI.create("https://m.myhome.go.kr/hws/portal/sch/selectRsdtRcritNtcInfo.do?pblancId="+ pblancId);
        String responseString = restTemplate.getForObject(uri, String.class);

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(responseString);
            jsonObj = (JSONObject) obj;

        }catch (Exception e){
            e.printStackTrace();
        }

        return jsonObj.toJSONString();

    }



    @CrossOrigin
    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/rest/test")
    public @ResponseBody String test() throws IOException {

        HashMap resultMap = new HashMap();
        int totalCount = testDao.getListCount();

        Random r = new Random();
        int Low = 1;
        int High = totalCount;
        int randNumberResult = r.nextInt(High-Low) + Low;

        Map proverbOne = testDao.getProverbOne(randNumberResult);

        System.out.println("proverbOne-->"+ proverbOne.get("content"));

        String strProverbOne =(String) proverbOne.get("content");

        List<HashMap> imageList = testDao.getImageList();


        Map imageOne = imageList.get(ThreadLocalRandom.current().nextInt(imageList.size()));

        String imageName  =(String) imageOne.get("image_name");

        System.out.println("imagename===>"+ imageName);

        System.out.println("sdklsdkflksdlfksldkflksdlfk");



        resultMap.put("imageName", imageName);
        resultMap.put("strProverbOne", strProverbOne);
        return JSONValue.toJSONString(resultMap);

    }



}
