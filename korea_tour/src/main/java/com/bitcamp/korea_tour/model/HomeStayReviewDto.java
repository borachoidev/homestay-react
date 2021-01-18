package com.bitcamp.korea_tour.model;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestayreview")
public class HomeStayReviewDto {
	private int photoNum;
	private int homeStayReviewNum;
	private int userNum;
	private int homeStayNum;
	private String photoName;

}
