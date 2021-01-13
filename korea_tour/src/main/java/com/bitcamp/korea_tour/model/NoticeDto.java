package com.bitcamp.korea_tour.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class NoticeDto {
	private String noticeNum;
	private String title;
	private String content;
	private Timestamp writeDay;
	private String viewTimes;
}
