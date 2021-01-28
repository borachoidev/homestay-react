package com.bitcamp.korea_tour.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.UserService;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController implements SessionNames {
	private final UserService us;

	/**
	 * 회원탈퇴(사용자), 회원삭제(관리자)
	 * @param request
	 */
	@DeleteMapping(value = "/users/{userNum}")
	public void deleteUser(HttpServletRequest request) {
		HttpSession session=request.getSession();
		UserDto user=(UserDto)session.getAttribute(USER);
		int loginNum=user.getUserNum();
		
		us.deleteUser(loginNum);
	}

	/**
	 * @return 사용자 목록(관리자페이지)
	 */
	@GetMapping(value="/users") 
	public JsonData<List<UserDto>>getAllUsers() {
		List<UserDto> list=us.getUserList();
		return new JsonData<List<UserDto>>(list);
	}
	
	@Data
	@AllArgsConstructor
	static class JsonData<T> {
		private T list;
	}

}
