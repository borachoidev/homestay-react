package com.bitcamp.korea_tour.model.service.course;

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
	private final JoinCourseMapper joinCourseMapper;

	@Override
	public List<JoinCourseDto> getAllCourseByTime(int start, int perPage) {
		Map<String, Integer> paging=new HashMap<String, Integer>();
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getAllCourseByTime(paging);
		return list;
	}

	@Override
	public List<JoinCourseDto> getAllCourseByLike(int start, int perPage) {
		Map<String, Integer> paging=new HashMap<String, Integer>();
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getAllCourseByLike(paging);
		return list;
	}

	@Override
	public JoinCourseDto getMyCourseDetail(int courseNum, int loginNum) {
		Map<String, Integer> nums=new HashMap<String, Integer>();
		nums.put("courseNum", courseNum);
		nums.put("loginNum", loginNum);
		JoinCourseDto dto=joinCourseMapper.getMyCourseDetail(nums);
		return dto;
	}

	@Override
	public List<JoinCourseDto> getMyCourseList(int loginNum, int start, int perPage) {
		Map<String, Integer> num=new HashMap<String, Integer>();
		Map<String, Integer> paging=new HashMap<String, Integer>();
		num.put("loginNum", loginNum);
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getMyCourseList(num, paging);
		return list;
	}

	@Override
	public List<JoinCourseDto> getMyMarkCourse(int loginNum, int start, int perPage) {
		Map<String, Integer> num=new HashMap<String, Integer>();
		Map<String, Integer> paging=new HashMap<String, Integer>();
		num.put("loginNum", loginNum);
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getMyMarkCourse(num, paging);
		return list;
	}

	@Override
	public List<JoinCourseDto> getTagCourseByTime(String tag, int start, int perPage) {
		Map<String, String> navTag=new HashMap<String, String>();
		Map<String, Integer> paging=new HashMap<String, Integer>();
		navTag.put("tag", tag);
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getTagCourseByTime(navTag, paging);
		return list;
	}

	@Override
	public List<JoinCourseDto> getTagCourseByLike(String tag, int start, int perPage) {
		Map<String, String> navTag=new HashMap<String, String>();
		Map<String, Integer> paging=new HashMap<String, Integer>();
		navTag.put("tag", tag);
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getTagCourseByLike(navTag, paging);
		return list;
	}

	@Override
	public List<JoinCourseDto> getSearchCourseByTime(String keyword, int start, int perPage) {
		Map<String, String> searchKeyword=new HashMap<String, String>();
		Map<String, Integer> paging=new HashMap<String, Integer>();
		searchKeyword.put("keyword", keyword);
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getSearchCourseByTime(searchKeyword, paging);
		return list;
	}

	@Override
	public List<JoinCourseDto> getSearchCourseByLike(String keyword, int start, int perPage) {
		Map<String, String> searchKeyword=new HashMap<String, String>();
		Map<String, Integer> paging=new HashMap<String, Integer>();
		searchKeyword.put("keyword", keyword);
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getSearchCourseByLike(searchKeyword, paging);
		return list;
	}

	@Override
	public List<JoinCourseDto> getCustomCourseByTime(String who, String during, String how, int start, int perPage) {
		Map<String, String> tags=new HashMap<String, String>();
		Map<String, Integer> paging=new HashMap<String, Integer>();
		tags.put("who", who);
		tags.put("during", during);
		tags.put("how", how);
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getCustomCourseByTime(tags, paging);
		return list;
	}

	@Override
	public List<JoinCourseDto> getCustomCourseByLike(String who, String during, String how, int start, int perPage) {
		Map<String, String> tags=new HashMap<String, String>();
		Map<String, Integer> paging=new HashMap<String, Integer>();
		tags.put("who", who);
		tags.put("during", during);
		tags.put("how", how);
		paging.put("start", start);
		paging.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getTagCourseByTime(tags, paging);
		return list;
	}

	@Override
	public JoinCourseDto getCourseDetail(int courseNum) {
		JoinCourseDto dto=joinCourseMapper.getCourseDetail(courseNum);
		return dto;
	}

	
}
