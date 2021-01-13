package com.bitcamp.korea_tour.model;

import java.util.List;

import lombok.Data;

@Data
public class PlacePhotoDto {
	private String photoNum;
	private String photoName;
	private List<String> upload;
	private String userNum;
	private String contentId;
	private int approveByAdmin;
}
