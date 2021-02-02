package com.bitcamp.korea_tour.model.service.homestay;

import java.util.HashMap;
import java.util.List;

import com.bitcamp.korea_tour.model.homestay.JoinHomeStayReservationDto;

public interface HomeStayReservationService {
	int getTotalCount(int loginNum);
	int getCountByWating(int loginNum);
	int getCountByCancel(int loginNum);
	int getCountByApproved(int loginNum);
	List<JoinHomeStayReservationDto> getAllDatas(HashMap<String, Object> map);
	List<JoinHomeStayReservationDto> getDatasByWating(HashMap<String, Object> map);
	List<JoinHomeStayReservationDto> getDatasByCancel(HashMap<String, Object> map);
	List<JoinHomeStayReservationDto> getDatasByApproved(HashMap<String, Object> map);
}
