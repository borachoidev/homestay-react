package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.NoticeDto;

@Mapper
public interface NoticeMapper {
	int getTotalCount(); 
	List<NoticeDto> getAllDatas(); 
	void insertNotice(NoticeDto dto);
	List<NoticeDto> getData(int noticeNum);
	void updateNotice(NoticeDto dto);
	void deleteNotice(int noticeNum);
	List<NoticeDto> getNewNotice();
	
}
