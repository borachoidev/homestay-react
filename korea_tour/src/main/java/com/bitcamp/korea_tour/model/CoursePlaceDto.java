package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("courseplace")
public class CoursePlaceDto {
	private int courseDetailNum;
	private int userNum;
	private int courseNum;
	private int placeNum;
	private int orderNum;
	
}
