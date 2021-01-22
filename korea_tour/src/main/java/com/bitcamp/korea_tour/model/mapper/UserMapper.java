
package com.bitcamp.korea_tour.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.UserDto;

@Mapper
public interface UserMapper {
	int getTotalCount();
	List<UserDto> getUserList();
	void insertUser(UserDto dto);
	UserDto getUserData(int userNum);
	void deleteUser(int userNum);
	int hasKey(Map<String, String> map);
	UserDto getUserByKey(Map<String, String> map);
}