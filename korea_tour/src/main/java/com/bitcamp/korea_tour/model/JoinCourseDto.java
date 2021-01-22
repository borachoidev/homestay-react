package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joincourse")
public class JoinCourseDto {
//	course_tb
	private int courseNum;
	private int userNum;
	private String name;
	private String content;
	private int open;
	private int share;
	private String who;
	private String during;
	private String how;
	private int totalLike;
	
//	courseplace_tb
	private int courseDetailNum;
//	private int userNum;
//	private int courseNum;
	private int contentId;
	private int orderNum;
	
//	place_tb
//	private int contentId;
	private String title;
	private String firstImage;
	private String overview;
	private String addr1;
	private int areaCode;
	
//	coursemark_tb
	private int courseMarkNum;
//	private int userNum;
//	private int courseNum;
	
}
