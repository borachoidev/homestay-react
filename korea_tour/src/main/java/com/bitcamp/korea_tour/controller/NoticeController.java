package com.bitcamp.korea_tour.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.JoinCourseMarkDto;
import com.bitcamp.korea_tour.model.NoticeDto;
import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.NoticeService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import com.bitcamp.korea_tour.model.service.paging.PagingService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
   
   @GetMapping({"/notice/{currentPage}","/notice/main/{currentPage}"})
   public String getNotice() {
	   
	   List<NoticeDto> newlist = new ArrayList<NoticeDto>();
	   newlist = ns.getNewNotice(start, perPage);
	   
	   Gson gson = new Gson();
	   JsonObject json = gson.toJsonTree(newlist).getAsJsonObject();
	   
	   return json.toString();
   }
   
   @GetMapping("/notice/list/{currentPage}")
   public JsonData<List<NoticeDto>> getNoticeList(@PathVariable(value = "currentPage") int currentPage) {
	    
	    totalCount=ns.getTotalCount();
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		list = ns.getAllDatas( start, perPage);

		return new JsonData<List<NoticeDto>>(list);
	   
   }
   
   @GetMapping("/notice/detail/{noticeNum}")
   public String getNoticeDetail(@PathVariable(name="noticeNum") int noticeNum) {
      List<NoticeDto> noticedetail = ns.getData(noticeNum);
      System.out.println(noticedetail);
      return "notice/detail";
   }
   
	@Data
	@AllArgsConstructor
	static class JsonData<T> {
		private T list;
	}
}