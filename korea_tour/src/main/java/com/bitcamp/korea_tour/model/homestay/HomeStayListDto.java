package com.bitcamp.korea_tour.model.homestay;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestaylist")
public class HomeStayListDto {
	//homestay, homestayphoto, homestaymark, homestayreview, homestaystar
	
	private int homeStayNum;
	private int userNum;
	private String title;
	private String addr1;
	private int approval;
	private int price;
	private int open;
	private String photoName;
	private int isMarked;
	private int countOfReview;
	private Double avgOfStar;
	
}
