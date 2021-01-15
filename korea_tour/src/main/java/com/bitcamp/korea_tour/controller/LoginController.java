package com.bitcamp.korea_tour.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

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
	
//	사용자 로그인
	
	public String userLogin(@PathVariable("sns") String sns, @RequestParam String code) {
		
		
		
			
			
			
		return "home";
	}
	
	@RequestMapping(value = "/login/{sns}",method = {RequestMethod.GET,RequestMethod.POST})
	public String userLogin(@PathVariable("sns") String sns, @RequestParam String code, HttpServletRequest request) {
		
		
		
		if(sns.equals("kakao")) {
			System.out.println("code: "+code);
			String kakaoToken = userService.getKakaoToken(code);
			UserDto dto = userService.getKakaoInfo(kakaoToken);
			System.out.println(dto.getKakaoKey());
			//최초 로그인일 경우에만 db에 저장, 세션에 userdto 실어주기
			if(!userService.hasKey(dto.getKakaoKey())) {
				userService.insertUser(dto);
				userService.setSession(dto, request);
			}else {
				userService.setSession(dto, request);
			}
		}
		return "redirect:/";
	}
	
	
	
}
