package com.bitcamp.korea_tour.model.homestay;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joinmypagereview")
public class JoinMypageReviewWithPhotoDto {
	private int homeStayReviewNum;
	private int hostNum;
	private int homeStayNum;
	private int relevel;
	private int regroup;
	private int loginNum;
	private String loginId;
	private String loginPhoto;
	private String content;
	private Date writeday;
	private int deleted;
	private String homePhoto;
}
