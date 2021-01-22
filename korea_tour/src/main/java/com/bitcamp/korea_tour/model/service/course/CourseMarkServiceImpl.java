package com.bitcamp.korea_tour.model.service.course;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseMarkDto;
import com.bitcamp.korea_tour.model.mapper.CourseMarkMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseMarkServiceImpl implements CourseMarkService{
	
	private final CourseMarkMapper mapper;

	@Override
	public int getTotalCourseMark(int userNum) {
		// TODO Auto-generated method stub
		return mapper.getTotalCourseMark(userNum);
	}

	@Override
	public void insertCourseMark(CourseMarkDto dto) {
		// TODO Auto-generated method stub
		mapper.insertCourseMark(dto);
	}

	@Override
	public void deleteCourseMark(int userNum, int courseNum) {
		// TODO Auto-generated method stub
		Map<String, Integer>map = new HashMap<String, Integer>();
		map.put("userNum", userNum);
		map.put("courseNum", courseNum);
		mapper.deleteCourseMark(map);
	}
	
	
}
