package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestayphoto")
public class HomeStayPhoto {
	private int homeStayPhotoNum;
	private int userNum;
	private int homeStayNum;
	private String photoName;
}
