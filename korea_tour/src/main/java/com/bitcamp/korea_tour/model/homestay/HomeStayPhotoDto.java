package com.bitcamp.korea_tour.model.homestay;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestayphoto")
public class HomeStayPhotoDto {
	private int homeStayPhotoNum;
	private int userNum;
	private int homeStayNum;
	private String photoName;
}
