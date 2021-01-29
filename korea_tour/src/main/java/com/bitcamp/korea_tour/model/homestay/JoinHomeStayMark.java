package com.bitcamp.korea_tour.model.homestay;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joinMark")
public class JoinHomeStayMark {
	private int homeStayMarkNum;
	private int customNum;
	private int homeStayNum;
	private int hostNum;
	private String title;
	private String addr1;
	private String content;
	private int approval;
	private int price;
	private int open;
}
