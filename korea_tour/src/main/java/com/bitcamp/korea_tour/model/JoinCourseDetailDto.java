package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joincoursedetail")
public class JoinCourseDetailDto {	
//	courseplace_tb
	private int coursePlaceNum;
	private int contentId;
	private int orderNum;
	
//	place_tb
	private String title;
	private String firstImage;
	private String overview;
	private String addr1;
	
}
