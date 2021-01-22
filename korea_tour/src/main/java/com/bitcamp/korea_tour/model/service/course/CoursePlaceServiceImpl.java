package com.bitcamp.korea_tour.model.service.course;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CoursePlaceDto;
import com.bitcamp.korea_tour.model.mapper.CoursePlaceMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoursePlaceServiceImpl implements CoursePlaceService{
	private final CoursePlaceMapper mapper;

	@Override
	public void insertCoursePlace(CoursePlaceDto dto) {
		// TODO Auto-generated method stub
		mapper.insertCoursePlace(dto);
	}

	@Override
	public void deleteForNewCoursePlace(int courseNum) {
		// TODO Auto-generated method stub
		mapper.deleteForNewCoursePlace(courseNum);
	}

	@Override
	public int getTotalCoursePlace(int courseNum) {
		// TODO Auto-generated method stub
		return mapper.getTotalCoursePlace(courseNum);
	}
	
	

}
