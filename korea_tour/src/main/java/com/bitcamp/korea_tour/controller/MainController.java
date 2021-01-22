package com.bitcamp.korea_tour.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.korea_tour.model.service.PlaceServiceImpl;

@Controller
public class MainController {

	@Autowired
	PlaceServiceImpl service;
	
	@GetMapping({"/index","/"})
	public String getMain(HttpServletRequest request) {
		return "home/home";
	}
	
	//로그인페이지 이동
	@GetMapping("/login/main")
	public String goLoginMain() {
		return "login/loginform";
	}
	
	//관리자 로그인폼 이동
	@GetMapping("/login/adminlogin")
	public String goAdminLogin() {
		return "login/adminloginform";
	}
	
}
