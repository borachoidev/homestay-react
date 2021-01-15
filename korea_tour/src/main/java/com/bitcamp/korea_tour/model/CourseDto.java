package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("MyCourseDto")
public class CourseDto {
	private String courseNum;
	private String name;
	private String customTag;
	private String selectTag;
	private String content;
	private int viewOrNot;
	private String contentIds;
	private int timesOfShare;
	private String userNum;
}
