package com.bitcamp.korea_tour.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.PlaceAnswerDto;
import com.bitcamp.korea_tour.model.mapper.PlaceAnswerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceAnswerServiceImpl implements PlaceAnswerService{
	
	private final PlaceAnswerMapper mapper;

	@Override
	public void insertPlaceAnswer(PlaceAnswerDto dto) {
		// TODO Auto-generated method stub
		mapper.insertPlaceAnswer(dto);
	}

	@Override
	public void insertPlaceAnswerRE(PlaceAnswerDto dto) {
		// TODO Auto-generated method stub
		mapper.insertPlaceAnswerRE(dto);
	}

	@Override
	public void deletePlaceAnswerByUser(int placeAnswerNum) {
		// TODO Auto-generated method stub
		mapper.deletePlaceAnswerByUser(placeAnswerNum);
	}

	@Override
	public void deletePlaceAnswerByAdmin(int placeAnswerNum) {
		// TODO Auto-generated method stub
		mapper.deletePlaceAnswerByAdmin(placeAnswerNum);
	}

	@Override
	public List<PlaceAnswerDto> getAnswerOfPlace(int contentId) {
		// TODO Auto-generated method stub
		return mapper.getAnswerOfPlace(contentId);
	}

	@Override
	public List<PlaceAnswerDto> getUserAnswer(HashMap<Integer, Integer> ua) {
		// TODO Auto-generated method stub
		return mapper.getUserAnswer(ua);
	}

	@Override
	public List<PlaceAnswerDto> getAdminAnswer(int relevel) {
		// TODO Auto-generated method stub
		return mapper.getAdminAnswer(relevel);
	}

}
