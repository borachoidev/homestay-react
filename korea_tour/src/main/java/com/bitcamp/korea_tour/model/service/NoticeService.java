package com.bitcamp.korea_tour.model.service;

import java.util.List;

import com.bitcamp.korea_tour.model.NoticeDto;

public interface NoticeService {
	public int getTotalCount();
	public List<NoticeDto> getAllDatas();
	public void insertNotice(NoticeDto dto);
	public NoticeDto getData(String num);
	public void updateNotice(NoticeDto dto);
	public void deleteNotice(String num);
}
