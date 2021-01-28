package com.bitcamp.korea_tour.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.korea_tour.model.service.AdminService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	private final HttpServletResponse response;
	
	@PostMapping("/login/admin/check")
	public void checkAdmin(
			@Param(value="id") String id,
			@Param(value="password") String password
			) {
		
		System.out.println(adminService.checkAdmin(id, password));
		
		try {
			if(adminService.checkAdmin(id, password)==1) {
				response.sendRedirect("/admin");
			}else  {
				response.sendRedirect("/login/admin");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
