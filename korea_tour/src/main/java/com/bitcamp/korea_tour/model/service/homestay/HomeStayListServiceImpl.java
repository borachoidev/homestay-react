package com.bitcamp.korea_tour.model.service.homestay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.homestay.HomeStayListDto;
import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;
import com.bitcamp.korea_tour.model.mapper.HomeStayListMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeStayListServiceImpl implements HomeStayListService {
	private final HomeStayListMapper homeStayListMapper;
	
	@Override
	public List<HomeStayListDto> getAllHomeStayList(int start, int perPage) {
		Map<String, Integer> paging=new HashMap<String, Integer>();
		paging.put("start", start);
		paging.put("perPage", perPage);
		return homeStayListMapper.getAllHomeStayList(paging);
	}
	
	@Override
	public List<HomeStayPhotoDto> setAllHomeStayPhoto(int homeStayNum) {
//		HomeStayListDto dto=new HomeStayListDto();
//		dto.setHomeStayPhotos(homeStayListMapper.getAllHomeStayPhoto(homeStayNum));
		return homeStayListMapper.getAllHomeStayPhoto(homeStayNum);
	}
	
	@Override
	public int getTotalHomeStayList() {
		return homeStayListMapper.getTotalHomeStayList();
	}
	
	@Override
	public Double getTest() {
		return homeStayListMapper.getTest();
	}
}
