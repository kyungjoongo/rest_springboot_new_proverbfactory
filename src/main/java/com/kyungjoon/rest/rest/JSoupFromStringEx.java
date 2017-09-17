package com.kyungjoon.rest.rest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupFromStringEx {

      public static void main(String[] args) throws Exception {
          String url = "https://www.myhome.go.kr/hws/portal/sch/selectRsdtRcritNtcDetailView.do?pblancId=2221";

          Document document = Jsoup.connect(url).get();

          Elements links = document.select("table[class=table_type2]");

          for (Element link : links) {

              System.out.println("link : " + link.attr("href"));
              System.out.println("text : " + link.text() + "\n");
          }
      }
  }