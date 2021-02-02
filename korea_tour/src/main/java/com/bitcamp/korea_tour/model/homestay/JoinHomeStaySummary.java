package com.bitcamp.korea_tour.model.homestay;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joinhomestaysummary")
public class JoinHomeStaySummary {
	private int homeStayNum;
	private String photoName;
	private String homeTitle;
	private String hostName;
	private String addr1;
	private String addr2;
}
