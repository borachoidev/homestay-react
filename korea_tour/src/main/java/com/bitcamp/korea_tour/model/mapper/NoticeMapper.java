package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.NoticeDto;

@Mapper
public interface NoticeMapper {
	int getTotalCount();
	List<NoticeDto> getAllDatas();
	void insertNotice(NoticeDto dto);
	NoticeDto getData(String num);
	void updateNotice(NoticeDto dto);
	void deleteNotice(String num);
	
	
}
