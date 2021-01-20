package com.bitcamp.korea_tour.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseLikeDto;
import com.bitcamp.korea_tour.model.mapper.CourseLikeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseLikeServiceImpl implements CourseLikeService {

	private final CourseLikeMapper mapper;

	@Override
	public int getTotalCourseLike(int courseNum) {
		// TODO Auto-generated method stub
		return mapper.getTotalCourseLike(courseNum);
	}

	@Override
	public void insertCourseLike(CourseLikeDto dto) {
		// TODO Auto-generated method stub
		mapper.insertCourseLike(dto);
	}

	@Override
	public void deleteCourseLike(String loginId, int courseNum) {
		// TODO Auto-generated method stub
		String CN = Integer.toString(courseNum);
		Map<String, String>map = new HashMap<String, String>();
		map.put("loginId", loginId);
		map.put("courseNum", CN);
		mapper.deleteCourseLike(map);
	}
	
	
}
