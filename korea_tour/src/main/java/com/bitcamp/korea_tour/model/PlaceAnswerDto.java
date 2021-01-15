package com.bitcamp.korea_tour.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("placeanswerdto")
public class PlaceAnswerDto {
	private String placeAnswerNum;
	private String content;
	private Timestamp writeDay;
	private int level;
	private int step;
	private int group;
	private int deleted;
	private String userNum;
	private String contentId;
}
