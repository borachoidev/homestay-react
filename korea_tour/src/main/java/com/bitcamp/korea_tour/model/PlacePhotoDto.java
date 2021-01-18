package com.bitcamp.korea_tour.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("placephoto")
public class PlacePhotoDto {
	private int photoNum;
	private int placeNum;
	private int approval;
	private String image;
}
