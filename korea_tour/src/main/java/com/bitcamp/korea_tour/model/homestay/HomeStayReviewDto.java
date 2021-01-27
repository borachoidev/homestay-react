package com.bitcamp.korea_tour.model.homestay;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestayreview")
public class HomeStayReviewDto {
	private int homeStayReviewNum;
	private Timestamp writeday;
	private int userNum;
	private int homeStayNum;
	private int relevel;
	private int regroup;
	private int loginNum;
	private String loginId;
	private String loginPhoto;
	private String photoName;
	private int deleted;
}
