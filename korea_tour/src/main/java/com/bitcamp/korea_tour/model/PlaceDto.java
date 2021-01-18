package com.bitcamp.korea_tour.model;

import lombok.Data;

@Data
public class PlaceDto {
	private int ContentId;
	private String title;
	private String firstImage1;
	private String firstImage2;
	private String overview;
	private String addr1;
	private String addr2;
	private String mapX;
	private String mapY;
	private int mLevel;
	private int areaCode;
	private String linkedURL;
}
