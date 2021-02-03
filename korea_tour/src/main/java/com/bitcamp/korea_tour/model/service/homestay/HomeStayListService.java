package com.bitcamp.korea_tour.model.service.homestay;

import java.util.List;

import com.bitcamp.korea_tour.model.homestay.HomeStayDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayListDto;


public interface HomeStayListService {
	List<HomeStayListDto> getAllHomeStayList(int start, int perPage);
	int getTotalHomeStayList();
	String getHomeStayPhotoOfList(int homeStayNum);
	int isMarked(int homeStayNum, int loginNum);
	Double getAvgOfStar(int homeStayNum);
	List<HomeStayDto> getAdminHomeStayList(int start, int perPage);
	int getTotalAdminHomeStayList();
	void approveHomeStay(int homeStayNum);
	void denyHomeStay(int homeStayNum);
}
