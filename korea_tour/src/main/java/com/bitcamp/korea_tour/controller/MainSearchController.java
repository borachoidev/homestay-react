package com.bitcamp.korea_tour.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainSearchController {
   SimpleDateFormat sdf = new SimpleDateFormat("MM");
   Date currDate = new Date();
   int currentMonth = Integer.parseInt(sdf.format(currDate));
   
   @GetMapping("/search")
   public String goSearch(
         @RequestParam(defaultValue="1") int currentPage,
         @RequestParam(required=false)String keyword,Model model
         ) {
      if(keyword.equals("")) {
         System.out.println("키워드가 널!!");
         if(currentMonth>=3 && currentMonth<6) {
            keyword="봄";
         }else if(currentMonth>=6 && currentMonth<9) {
            keyword="여름";
         }else if(currentMonth>=9 && currentMonth<12) {
            System.out.println(currentMonth);
            keyword="가을";
         }else {
            keyword="겨울";
         }
      }
      model.addAttribute("currentPage", currentPage);
      model.addAttribute("keyword", keyword);   
      return "search/result";
   }
   
   @GetMapping("/course.search")
   public String goCourseSearch(
         @RequestParam(defaultValue="1") int currentPage,
         @RequestParam String who,
         @RequestParam String during,
         @RequestParam String how,Model model
         ) {
      
      model.addAttribute("currentPage", currentPage);
      model.addAttribute("who", who);
      model.addAttribute("during", during);
      model.addAttribute("how", how);
      return "course/search";
      
      
   }
}