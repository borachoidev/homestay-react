package com.bitcamp.korea_tour.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.NoticeDto;

import com.bitcamp.korea_tour.model.service.NoticeService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import com.bitcamp.korea_tour.model.service.paging.PagingService;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NoticeController implements SessionNames {
   
   private final NoticeService ns;
   
   private final PagingService pagingService;
   
   int totalCount=0;
   int start=0;
   int perPage=0;
   int totalPage=0;

   @GetMapping("/notice/{currentPage}")
   public JsonData<List<NoticeDto>> getNoticeList(@PathVariable(name = "currentPage") int currentPage) {

      totalCount=ns.getTotalCount();
      /* System.out.println(totalCount); */
      start=pagingService.getPagingData(totalCount, currentPage).get("start");
      perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
      totalPage=pagingService.getPagingData(totalCount, currentPage).get("totalPage");
 
      System.out.println("공지사항 토탈페이지: "+totalPage);
      List<NoticeDto> list = ns.getAllDatas(start, perPage);

      return new JsonData<List<NoticeDto>>(list, totalPage);
      
   }
   
   
     @GetMapping("/notice/detail/{noticeNum}")
     public JsonDetail getNoticeDetail(@PathVariable(name="noticeNum") int noticeNum) {
     NoticeDto dto = ns.getData(noticeNum);
     
     return new JsonDetail(dto);
     }
    
   
     @DeleteMapping(value = "/noticedelete/{noticeNum}")
     public void
     deleteNotice(@PathVariable(name="noticeNum") int noticeNum) 
     { ns.deleteNotice(noticeNum); 
     }
    
     @RequestMapping(value = "/noticeupdate/{noticeNum}", method = RequestMethod.POST)
     public void updateNotice(@RequestBody NoticeDto dto,@PathVariable int noticeNum) {
    	 
    	 ns.updateNotice(noticeNum, dto);
     }
   
   @Data
   @AllArgsConstructor
   static class JsonData<T> {
      private T notices;
      int totalPage;
   }
   
   @Data
   @AllArgsConstructor
   static class JsonDataList {
      private NoticeDto noticeDto; //dto
   }
   
   @Data
   @AllArgsConstructor
   static class JsonDetail {
      private NoticeDto noticeDetail;
   }
   
   @Data
   @AllArgsConstructor
   static class JsonRequest {
      private String title;
      private String content;
      private int views;
   }

}