package com.bitcamp.korea_tour.model.service.course;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.mapper.CourseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
	private final CourseMapper mapper;

	@Override
	public int myCourseCount(int userNum) {
		// TODO Auto-generated method stub
		return mapper.myCourseCount(userNum);
	}

	@Override
	public CourseDto getMyCourseData(int userNum) {
		// TODO Auto-generated method stub
		return mapper.getMyCourseData(userNum);
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

	@Override
	public void updateShare(int courseNum) {
		// TODO Auto-generated method stub
		mapper.updateShare(courseNum);
	}

	@Override
	public void updateCourseName(int courseNum) {
		// TODO Auto-generated method stub
		mapper.updateCourseName(courseNum);
	}
	
	
}
