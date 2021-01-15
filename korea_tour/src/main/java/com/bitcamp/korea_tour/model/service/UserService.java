package com.bitcamp.korea_tour.model.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.bitcamp.korea_tour.model.UserDto;
import com.fasterxml.jackson.databind.JsonNode;

public interface UserService {
	
	void getUserList(Model model);
	void getUserData(String userNum, Model model);
	void deleteUser(String userNum);
	String getKakaoToken(String code);
	UserDto getKakaoInfo(String token);
	boolean hasKey(String key);
	void insertUser(UserDto dto);
	void setSession(UserDto dto,  HttpServletRequest request);
}
