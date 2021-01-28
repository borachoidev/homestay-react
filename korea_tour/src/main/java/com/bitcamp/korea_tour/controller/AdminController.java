package com.bitcamp.korea_tour.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.korea_tour.model.AdminDto;
import com.bitcamp.korea_tour.model.service.AdminService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController implements SessionNames {
	
	private final AdminService adminService;
	
	@PostMapping("/login/admin/check")
	public String checkAdmin(
			@Param(value="id") String id,
			@Param(value="password") String password,
			HttpServletRequest request
			) {
		
		System.out.println(adminService.checkAdmin(id, password));
		
		if(adminService.checkAdmin(id, password)==1) {
			AdminDto admin=adminService.getAdminData(id, password);
			HttpSession session=request.getSession();
			session.setAttribute(ADMIN, admin);
			
			return "login/adminloginform";
		}else  {
			return "admin/adminmain";
		}
	}
}
