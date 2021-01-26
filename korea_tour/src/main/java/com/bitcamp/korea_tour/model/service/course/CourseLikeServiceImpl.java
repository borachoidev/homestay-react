package com.bitcamp.korea_tour.model.service.course;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseLikeDto;
import com.bitcamp.korea_tour.model.mapper.CourseLikeMapper;
import com.bitcamp.korea_tour.model.mapper.CourseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseLikeServiceImpl implements CourseLikeService {

	private final CourseLikeMapper courseLikeMapper;

	@Override
	public int getTotalCourseLike(int courseNum) {
		// TODO Auto-generated method stub
		return courseLikeMapper.getTotalCourseLike(courseNum);
	}

	@Override
	public void insertCourseLike(CourseLikeDto dto) {
		courseLikeMapper.insertCourseLike(dto);
		
	}

	@Override
	public void deleteCourseLike(int likeNum) {
		// TODO Auto-generated method stub
		
		courseLikeMapper.deleteCourseLike(likeNum);
		
	}
	
}
