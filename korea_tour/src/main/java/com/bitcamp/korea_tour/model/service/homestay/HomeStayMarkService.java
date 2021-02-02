package com.bitcamp.korea_tour.model.service.homestay;

import org.apache.ibatis.annotations.Param;

public interface HomeStayMarkService {
//	List<JoinHomeStayMark> getMarkList(int userNum);
//	int getTotalCount(int userNum);
	void insertMark(@Param("homeStayNum") int homeStayNum, int loginNum);
	void deleteMark(@Param("homeStayNum") int homeStayNum, int loginNum);
}
