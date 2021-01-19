package com.bitcamp.korea_tour.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.UserDto;

@Mapper
public interface UserMapper {
	List<UserDto> getUserList();
	void insertUser(UserDto dto);
	UserDto getUserData(String userNum);
	void deleteUser(String userNum);
	int hasKey(Map<String, String> map);
	UserDto getUserByKey(Map<String, String> map);
}
