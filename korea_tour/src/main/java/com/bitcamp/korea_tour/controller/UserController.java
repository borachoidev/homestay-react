package com.bitcamp.korea_tour.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userservice;


	//회원탈퇴하기
	@DeleteMapping(value = "/users/{userNum}")
	public void deleteUser(@PathVariable(value = "userNum")int userNum) {
		userservice.deleteUser(userNum);
	}
	
	/*
	 * //유저모아보기 - 페이징 x
	 * 
	 * @GetMapping("/users/admin/getAllUsers") public List<UserDto>
	 * getAllUsers(HttpServletRequest request) {
	 * 
	 * }
	 */
}
