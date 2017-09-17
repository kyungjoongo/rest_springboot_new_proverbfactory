package com.kyungjoon.rest.rest;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class LhControllerTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lhList() throws Exception {


        ModelAndView mav = new ModelAndView();
        HashMap resultMap = new HashMap();

        String baseUrl = "";
        RestTemplate restTemplate = new RestTemplate();


        URI uri = URI.create("https://www.myhome.go.kr//hws/portal/sch/selectRsdtRcritNtcList.do?pageIndex=2&recordCountPerPage=100&pageSize=100&pageUnit=100");
        String responseString = restTemplate.getForObject(uri, String.class);


        JSONParser parser = new JSONParser();
        Object obj = parser.parse(responseString);
        JSONObject jsonObj = (JSONObject) obj;

        org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) jsonObj.get("resultList");

        for ( int i=0; i<jsonArray.size();i++){

            HashMap vmap = (HashMap) jsonArray.get(i);

            System.out.println(vmap.get("guidanceCn"));
        }



    }

}