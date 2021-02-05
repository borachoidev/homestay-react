package com.bitcamp.korea_tour.model.service.homestay;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;
import com.bitcamp.korea_tour.model.mapper.HomeStayHostPhotoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeStayHostPhotoServiceImpl implements HomeStayHostPhotoService {
	
	private final HomeStayHostPhotoMapper mapper;

	@Override
	public void insertPhoto(HomeStayPhotoDto dto) {
		// TODO Auto-generated method stub
		mapper.insertPhoto(dto);
	}

	@Override
	public void deletePhoto(int homeStayPhotoNum) {
		// TODO Auto-generated method stub
		mapper.deletePhoto(homeStayPhotoNum);
	}

	@Override
	public void updatePhoto(int homeStayPhotoNum) {
		// TODO Auto-generated method stub
		mapper.updatePhoto(homeStayPhotoNum);
	}
}