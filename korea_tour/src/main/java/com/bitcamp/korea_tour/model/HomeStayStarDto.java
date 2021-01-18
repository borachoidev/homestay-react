package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestaystar")
public class HomeStayStarDto {
	private int homeStayStarNum;
	private int userNum;
	private int homeStayNum;
	private int homeStayReviewNum;
	private double cleanliness;
	private double communication;
	private double checkin;
	private double accuracy;
	private double location;
	private double satisfactionForPrice;
	
}
