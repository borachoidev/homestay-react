package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("user")
public class UserDto {
	private String userNum;
	private String email;
	private String name;
	private String birth;
	private String gender;
	private String photo;
	private String naverKey;
	private String kakaoKey;
	private String googleKey;
}
