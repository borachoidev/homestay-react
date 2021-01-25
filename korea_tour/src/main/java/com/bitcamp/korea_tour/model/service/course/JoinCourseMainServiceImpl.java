package com.bitcamp.korea_tour.model.service.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.JoinCourseDto;
import com.bitcamp.korea_tour.model.mapper.JoinCourseMainMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinCourseMainServiceImpl implements JoinCourseMainService {
	private final JoinCourseMainMapper joinCourseMainMapper;

	@Override
	public List<JoinCourseDto> getAllCourseByTime(int start, int perPage) {
		Map<String, Integer> paging=new HashMap<String, Integer>();
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMainMapper.getAllCourseByTime(paging);
		
		System.out.println(joinCourseMainMapper);
		return list;
	}

	@Override
	public List<JoinCourseDto> getAllCourseByLike(int start, int perPage) {
		Map<String, Integer> paging=new HashMap<String, Integer>();
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMainMapper.getAllCourseByLike(paging);
		return list;
	}
	
	@Override
	public int getAllTotalCount() {
		return joinCourseMainMapper.getAllTotalCount();
	}

}
