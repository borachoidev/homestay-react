package com.bitcamp.korea_tour.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
      totalPage=pagingService.getPagingData(totalPage, currentPage).get("totalPage");
      HashMap<String, Object> map=new HashMap<String, Object>();
      map.put("start", start);
      map.put("perPage", perPage);
   
      List<NoticeDto> list = ns.getAllDatas(map);

      return new JsonData<List<NoticeDto>>(list, totalPage);
      
   }
   
   
     @GetMapping("/notice/detail/{noticeNum}")
     public JsonDetail getNoticeDetail(@PathVariable(name="noticeNum") int noticeNum) {
     NoticeDto dto = ns.getData(noticeNum);
     System.out.println(dto);
     
     
     return new JsonDetail(dto);
     }
    
   
     
     @PostMapping(value = "/noticeinsert") 
     public void insertNotice(@RequestBody JsonRequest js) {
     NoticeDto dto = new NoticeDto();
     System.out.println(js);
     dto.setTitle(js.getTitle());
     dto.setContent(js.getContent());
     dto.setViews(js.getViews());
      ns.insertNotice(dto); }
     
     @DeleteMapping(value = "/noticedelete/{noticeNum}")
     public void
     deleteNotice(@PathVariable int noticeNum) { ns.deleteNotice(noticeNum); }
    
   
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