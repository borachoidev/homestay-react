package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
	
	@GetMapping({"/notice","/notice/main"})
	public String getNotice() {
		
		return "notice/main";
	}
	
	@GetMapping("/notice/list")
	public String getNoticeList() {
		
		return "notice/list";
	}
	@GetMapping("/notice/detail")
	public String getNoticeDetail() {
		
		return "notice/detail";
	}
}
