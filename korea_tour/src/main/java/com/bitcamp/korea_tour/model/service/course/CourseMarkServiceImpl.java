package com.bitcamp.korea_tour.model.service.course;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseMarkDto;
import com.bitcamp.korea_tour.model.mapper.CourseMarkMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseMarkServiceImpl implements CourseMarkService{
	
	private final CourseMarkMapper courseMarkMapper;

	@Override
	public void insertCourseMark(CourseMarkDto dto) {
		courseMarkMapper.insertCourseMark(dto);
	}

	@Override
	public void deleteCourseMark(int courseMarkNum) {
		courseMarkMapper.deleteCourseMark(courseMarkNum);
	}

	@Override
	public List<CourseMarkDto> getCourseMark(int courseNum) {
		// TODO Auto-generated method stub
		List<CourseMarkDto> list = courseMarkMapper.getCourseMark(courseNum);
		return list;
	}

	@Override
	public int getMyCourseMarkCount(int loginNum) {
		// TODO Auto-generated method stub
		return courseMarkMapper.getMyCourseMarkCount(loginNum);
	}
	
	
	
	
}
