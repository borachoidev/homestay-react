package com.bitcamp.korea_tour.model;

import java.util.List;

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
	private List<HomeStayPhotoDto> homeStayPhotos;
	private List<HomeStayMarkDto> homeStayMarkNums;
	private int countOfReview;
	private int avgOfStar;
	
}
