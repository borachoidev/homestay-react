package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainSearchController {
	
	@GetMapping("/search")
	public String goSearch(@RequestParam(defaultValue="1") int currentPage,@RequestParam String keyword,Model model ) {
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("keyword", keyword);	
		return "/search/allsearch";
	}
}
