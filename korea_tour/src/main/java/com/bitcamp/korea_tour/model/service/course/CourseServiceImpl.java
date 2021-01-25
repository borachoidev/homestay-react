package com.bitcamp.korea_tour.model.service.course;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.mapper.CourseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
	private final CourseMapper courseMapper;

	@Override
	public void insertCourseTitle(String name, int loginNum) {
		Map<String, String> title=new HashMap<String, String>();
		Map<String, Integer> num=new HashMap<String, Integer>();
		title.put("name", name);
		num.put("loginNum", loginNum);
		courseMapper.insertCourseTitle(title, num);
	}

	@Override
	public void deleteMyCourse(int courseNum) {
		courseMapper.deleteMyCourse(courseNum);
	}

	@Override
	public void updateShare(int courseNum) {
		courseMapper.updateShare(courseNum);
	}

	@Override
	public void updateCourseDetail(CourseDto dto) {
		courseMapper.updateCourseDetail(dto);
	}

	@Override
	public int getMyCourseCount(int loginNum) {
		// TODO Auto-generated method stub
		return courseMapper.getMyCourseCount(loginNum);
	}
	
}
