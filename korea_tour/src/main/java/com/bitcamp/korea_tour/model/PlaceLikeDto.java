package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("placelike")
public class PlaceLikeDto {
	private int placelikeNum;
	private int placeNum;
	private String loginId;
	private int likeCheck;
}
