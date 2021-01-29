package com.bitcamp.korea_tour.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.korea_tour.model.AdminDto;
import com.bitcamp.korea_tour.model.service.AdminService;
import com.bitcamp.korea_tour.model.service.UserService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController implements SessionNames {
	
	private final AdminService adminService;
	private final UserService userService;
	
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
			
			return "admin/adminmain";
		}else  {
			return "login/adminloginform";
		}
	}
	
	
	//회원강퇴
	@PostMapping("/admin/member/delete")
	public String deleteUserByAdmin(@RequestParam int userNum)
	{
		userService.deleteUserByAdmin(userNum);
		
		return "redirect:/admin/member/list?currentPage=1";
	}
}
