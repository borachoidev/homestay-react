package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestayreviewphoto")
public class HomeStayReviewPhotoDto {
	private int photoNum;
	private String photoName;
	private int homeStayReviewNum;

}
