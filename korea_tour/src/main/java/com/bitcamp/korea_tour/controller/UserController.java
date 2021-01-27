package com.bitcamp.korea_tour.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.AdminDto;
import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService us;


	//회원탈퇴하기
	@DeleteMapping(value = "/users/{userNum}")
	public void deleteUser(@PathVariable(value = "userNum")int userNum) {
		us.deleteUser(userNum);
	}

	@GetMapping("/users/getalluser") 
	public List<UserDto>getAllUsers() {
		List<UserDto> list = new ArrayList<UserDto>();	
		list = us.getUserList();
		return list;
	}

}
