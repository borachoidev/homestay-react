package com.bitcamp.korea_tour.model.service.course;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseLikeDto;
import com.bitcamp.korea_tour.model.mapper.CourseLikeMapper;
import com.bitcamp.korea_tour.model.mapper.CourseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseLikeServiceImpl implements CourseLikeService {

	private final CourseLikeMapper courseLikeMapper;
	private final CourseMapper courseMapper;

	@Override
	public int getTotalCourseLike(int courseNum) {
		// TODO Auto-generated method stub
		return courseLikeMapper.getTotalCourseLike(courseNum);
	}

	@Override
	public void insertCourseLike(CourseLikeDto dto) {
		courseLikeMapper.insertCourseLike(dto);
		Map<String, Integer> courseLike=new HashMap<String, Integer>();
		courseLike.put("courseNum", dto.getCourseNum());
		courseLike.put("totalLike", this.getTotalCourseLike(dto.getCourseNum()));
		courseMapper.updateCourseTotalLike(courseLike);
	}

	@Override
	public void deleteCourseLike(int loginNum, int courseNum) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("loginNum", loginNum);
		map.put("courseNum", courseNum);
		courseLikeMapper.deleteCourseLike(map);
		
	}
	
}
