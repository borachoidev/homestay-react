package com.bitcamp.korea_tour.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.NoticeDto;
import com.bitcamp.korea_tour.model.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{
	
	private NoticeMapper mapper;
	

	@Override
	public List<NoticeDto> getAllDatas() {
		// TODO Auto-generated method stub
		return mapper.getAllDatas();
	}

	@Override
	public void insertNotice(NoticeDto dto) {
		// TODO Auto-generated method stub
		mapper.insertNotice(dto);
	}

	@Override
	public NoticeDto getData(String num) {
		// TODO Auto-generated method stub
		return mapper.getData(num);
	}

	@Override
	public void updateNotice(NoticeDto dto) {
		// TODO Auto-generated method stub
		mapper.updateNotice(dto);
	}

	@Override
	public void deleteNotice(String num) {
		// TODO Auto-generated method stub
		mapper.deleteNotice(num);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return mapper.getTotalCount();
	}
	

}
