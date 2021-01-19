package com.bitcamp.korea_tour.model;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestayreviewphoto")
public class HomeStayReviewPhotoDto {
	private int homeStayReviewNum;
	private int userNum;
	private int homeStayNum;
	private Timestamp writeday;
	private int level;
	private int step;
	private int group;
	private String loginId;
	private String loginPhoto;

}
