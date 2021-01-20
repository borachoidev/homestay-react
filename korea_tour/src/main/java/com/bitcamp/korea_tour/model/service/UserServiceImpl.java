package com.bitcamp.korea_tour.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.mapper.UserMapper;
import com.bitcamp.korea_tour.model.service.login.setting.SessionNames;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService,SessionNames {
	
	private final UserMapper mapper;
	
	@Override
	public void getUserList(Model model) {
		List<UserDto> userList=mapper.getUserList();
		model.addAttribute("list", userList);

	}

	@Override
	public void insertUser(UserDto dto) {
		mapper.insertUser(dto);
	}

	@Override
	public void getUserData(String userNum, Model model) {
		UserDto userDto=mapper.getUserData(userNum);
		model.addAttribute("user", userDto);
	}

	@Override
	public void deleteUser(String userNum) {
		mapper.deleteUser(userNum);
	}

	
	@Override
	public boolean hasKey(String sns, String key) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("sns", sns);
		map.put("key", key);
		System.out.println(mapper.hasKey(map));
		if(mapper.hasKey(map)!=0) return true;
		
		return false;
	}
	
	//세션에 실어둘 사용자 dto
	public UserDto getUserByKey(String sns, String key) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("sns", sns);
		map.put("key", key);
		UserDto userDto=mapper.getUserByKey(map);
		return userDto;
	}
	
	@Override
	public void setSession(UserDto dto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(USER, dto);
	}
	
}