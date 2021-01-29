package com.bitcamp.korea_tour.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("homestaymark")
public class HomeStayMarkDto {
	private int homeStayMarkNum;
	private int userNum;
	private int homeStayNum;
}
