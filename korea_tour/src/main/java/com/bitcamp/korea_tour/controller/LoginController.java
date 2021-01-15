package com.bitcamp.korea_tour.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {
	
	private final UserService userService;
	
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
	
	//사용자 로그인
	@GetMapping("/login/{sns}")
	public String userLogin(@PathVariable("sns") String sns, @RequestParam("code") String code, HttpServletRequest request) {
		
		String token="";
		UserDto dto=userService.getKakaoInfo(token);
		
		if(sns.equals("kakao")) {
			token=userService.getKakaoToken(code);
			System.out.println("controller accessToken: "+token);
			if(userService.hasKey(sns, dto.getKakaoKey())) {
				userService.insertUser(dto, request);
			}
		}
		return "redirect:home";
	}
	
	
	
}
