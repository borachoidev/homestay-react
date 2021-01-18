package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("coursedetail")
public class CourseDetailDto {
	private int courseDetailNum;
	private int userNum;
	private int courseNum;
	private int placeNum;
	private int orderNum;
	private String who;
	private String during;
	private String how;
}
