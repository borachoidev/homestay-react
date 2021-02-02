package com.bitcamp.korea_tour.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeStayMarkMapper {
//	List<JoinHomeStayMark> getMarkList(int userNum);
//	int getTotalCount(int userNum);
	void insertMark(Map<String, Integer> map);
	void deleteMark(Map<String, Integer> map);
}
