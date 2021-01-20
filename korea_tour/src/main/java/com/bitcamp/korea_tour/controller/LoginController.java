package com.bitcamp.korea_tour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	//로그인페이지 이동
	@GetMapping("/login/main")
	public String goLoginMain() {
		return "login/loginform";
	}   
	
	//관리자로그인폼 이동
	@GetMapping("/login/adminlogin")
	public String goAdminLogin() {
		return "login/adminloginform";
	}
	
	
}
