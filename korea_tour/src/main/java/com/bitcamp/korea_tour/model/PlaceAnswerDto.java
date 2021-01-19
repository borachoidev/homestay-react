package com.bitcamp.korea_tour.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("placeanswer")
public class PlaceAnswerDto {
	private int placeAnswerNum;
	private int placeNum;
	private String loginId;
	private String loginPhoto;
	private String content;
	private Timestamp writeDay;
	private int level;
	private int step;
	private int group;
	private int deleted;
}
