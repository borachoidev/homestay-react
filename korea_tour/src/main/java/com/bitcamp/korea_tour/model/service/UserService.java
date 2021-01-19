package com.bitcamp.korea_tour.model.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bitcamp.korea_tour.model.UserDto;

public interface UserService {
	
	void getUserList(Model model);
	void getUserData(String userNum, Model model);
	void deleteUser(String userNum);
	void insertUser(UserDto dto);
	boolean hasKey(String sns, String key);
	UserDto getUserByKey(String sns, String key);
	void setSession(UserDto dto,  HttpServletRequest request);
}
