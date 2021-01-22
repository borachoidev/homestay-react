package com.bitcamp.korea_tour.model.service.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.JoinCourseDto;
import com.bitcamp.korea_tour.model.mapper.JoinCourseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinCourseServiceImpl implements JoinCourseService {
	private final JoinCourseMapper mapper;

	@Override
	public List<JoinCourseDto> getMyCourseList(int loginNum) {
		// TODO Auto-generated method stub
		List<JoinCourseDto> list = new ArrayList<JoinCourseDto>();
		list = mapper.getMyCourseList(loginNum);
		return list;
	}

	@Override
	public JoinCourseDto getMyCourseDetail(int courseNum) {
		// TODO Auto-generated method stub
		return mapper.getMyCourseDetail(courseNum);
	}

	@Override
	public List<JoinCourseDto> getMyMarkCourse(int loginNum) {
		// TODO Auto-generated method stub
		List<JoinCourseDto> list = new ArrayList<JoinCourseDto>();
		list = mapper.getMyMarkCourse(loginNum);
		return list;
	}

	@Override
	public List<JoinCourseDto> getAllCourseByTime() {
		// TODO Auto-generated method stub
		List<JoinCourseDto> list = new ArrayList<JoinCourseDto>();
		list = mapper.getAllCourseByTime();
		return list;
	}

	@Override
	public List<JoinCourseDto> getAllCourseByLike() {
		// TODO Auto-generated method stub
		List<JoinCourseDto> list = new ArrayList<JoinCourseDto>();
		list = mapper.getAllCourseByLike();
		return list;
	}

	@Override
	public List<JoinCourseDto> getTagCourseByTime(String who, String during, String how) {
		// TODO Auto-generated method stub
		Map<String, String> tag = new HashMap<String, String>();
		tag.put("who", who);
		tag.put("during", during);
		tag.put("how", how);
		List<JoinCourseDto> dto = mapper.getTagCourseByTime(tag);
		return dto;
	}

	@Override
	public List<JoinCourseDto> getTagCourseByLike(String who, String during, String how) {
		// TODO Auto-generated method stub
		Map<String, String> tag = new HashMap<String, String>();
		tag.put("who", who);
		tag.put("during", during);
		tag.put("how", how);
		List<JoinCourseDto> dto = mapper.getTagCourseByLike(tag);
		return dto;
	}

	@Override
	public List<JoinCourseDto> getSearchCourseByTime(String keyword) {
		// TODO Auto-generated method stub
		List<JoinCourseDto> list = new ArrayList<JoinCourseDto>();
		list = mapper.getSearchCourseByTime(keyword);
		return list;

	}

	@Override
	public List<JoinCourseDto> getSearchCourseByLike(String keyword) {
		// TODO Auto-generated method stub
		List<JoinCourseDto> list = new ArrayList<JoinCourseDto>();
		list = mapper.getSearchCourseByLike(keyword);
		return list;
	}

	@Override
	public List<JoinCourseDto> getCustomCourseByTime(String who, String during, String how) {
		// TODO Auto-generated method stub
		Map<String, String> tag = new HashMap<String, String>();
		tag.put("who", who);
		tag.put("during", during);
		tag.put("how", how);
		List<JoinCourseDto> dto = mapper.getCustomCourseByTime(tag);
		return dto;
	}

	@Override
	public List<JoinCourseDto> getCustomCourseByLike(String who, String during, String how) {
		// TODO Auto-generated method stub
		Map<String, String> tag = new HashMap<String, String>();
		tag.put("who", who);
		tag.put("during", during);
		tag.put("how", how);
		List<JoinCourseDto> dto = mapper.getCustomCourseByLike(tag);
		return dto;
	}
	
}
