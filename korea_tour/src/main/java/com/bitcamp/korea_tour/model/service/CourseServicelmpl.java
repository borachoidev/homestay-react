package com.bitcamp.korea_tour.model.service;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.mapper.CourseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServicelmpl implements CourseService {
	
	private CourseMapper mapper;

	@Override
	public int myCourseCount() {
		// TODO Auto-generated method stub
		return mapper.myCourseCount();
	}

	@Override
	public void getMyCourseData() {
		// TODO Auto-generated method stub
		mapper.getMyCourseData();
	}

	@Override
	public void insertCourseTitle(CourseDto dto) {
		// TODO Auto-generated method stub
		mapper.insertCourseTitle(dto);
	}

	@Override
	public void deleteMyCourse(int courseNum) {
		// TODO Auto-generated method stub
		mapper.deleteMyCourse(courseNum);
	}
	
	
}
