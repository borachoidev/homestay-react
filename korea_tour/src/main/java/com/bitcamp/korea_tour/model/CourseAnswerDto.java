package com.bitcamp.korea_tour.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CourseAnswerDto {
	private String courseAnswerNum;
	private String content;
	private Timestamp writeday;
	private int level;
	private int step;
	private int group;
	private String userNum;
	private String courseNum;
}
