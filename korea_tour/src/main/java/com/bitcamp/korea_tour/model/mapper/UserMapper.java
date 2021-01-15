package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.Alias;

import com.bitcamp.korea_tour.model.UserDto;

@Mapper
@Alias("usermapper")
public interface UserMapper {
	List<UserDto> getUserList();
	void insertUser(UserDto dto);
	UserDto getUserData(String userNum);
	void deleteUser(String userNum);
	int hasKey(String key);
}
