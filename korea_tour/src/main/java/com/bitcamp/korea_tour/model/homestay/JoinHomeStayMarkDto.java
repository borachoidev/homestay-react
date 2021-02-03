package com.bitcamp.korea_tour.model.homestay;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("joinmark")
public class JoinHomeStayMarkDto {	// 마이페이지 즐겨찾기
	private int homeStayMarkNum;	// 즐겨찾기 고유값
	private int customNum;			// 고객 userNum
	private int homeStayNum;		// 홈스테이 고유값
	private int hostNum;			// 호스트 userNum
	private String title;			// 홈스테이 이름
	private String addr1;
	private String content;
	private int approval;
	private int price;
	private int open;
}
