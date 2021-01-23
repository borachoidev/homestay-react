package com.bitcamp.korea_tour.model.service.course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.JoinCourseDto;
import com.bitcamp.korea_tour.model.mapper.CourseMapper;
import com.bitcamp.korea_tour.model.mapper.JoinCourseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinCourseServiceImpl implements JoinCourseService {
	private final JoinCourseMapper joinCourseMapper;
	private final CourseMapper courseMapper;

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
	public CourseDto getMyCourseData(int courseNum, int loginNum) {
		Map<String, Integer> nums=new HashMap<String, Integer>();
		nums.put("courseNum", courseNum);
		nums.put("loginNum", loginNum);
		return courseMapper.getMyCourseData(nums);
	}

	@Override
	public List<JoinCourseDto> getMyCourseDetail(int courseNum, int loginNum) {
		Map<String, Integer> nums=new HashMap<String, Integer>();
		nums.put("courseNum", courseNum);
		nums.put("loginNum", loginNum);
		List<JoinCourseDto> list=joinCourseMapper.getMyCourseDetail(nums);
		return list;
	}

	@Override
	public List<JoinCourseDto> getMyCourseList(int loginNum, int start, int perPage) {
		Map<String, Object> obj=new HashMap<String, Object>();
		obj.put("loginNum", loginNum);
		obj.put("start", start);
		obj.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getMyCourseList(obj);
		return list;
	}

	@Override
	public List<JoinCourseDto> getMyMarkCourse(int loginNum, int start, int perPage) {
		Map<String, Object> obj=new HashMap<String, Object>();
		obj.put("loginNum", loginNum);
		obj.put("start", start);
		obj.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getMyMarkCourse(obj);
		return list;
	}

	@Override
	public List<JoinCourseDto> getTagCourseByTime(String tag, int start, int perPage) {
		Map<String, Object> obj=new HashMap<String, Object>();
		obj.put("tag", tag);
		obj.put("start", start);
		obj.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getTagCourseByTime(obj);
		return list;
	}

	@Override
	public List<JoinCourseDto> getTagCourseByLike(String tag, int start, int perPage) {
		Map<String, Object> obj=new HashMap<String, Object>();
		obj.put("tag", tag);
		obj.put("start", start);
		obj.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getTagCourseByLike(obj);
		return list;
	}

	@Override
	public List<JoinCourseDto> getSearchCourseByTime(String keyword, int start, int perPage) {
		Map<String, Object> obj=new HashMap<String, Object>();
		obj.put("keyword", keyword);
		obj.put("start", start);
		obj.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getSearchCourseByTime(obj);
		return list;
	}

	@Override
	public List<JoinCourseDto> getSearchCourseByLike(String keyword, int start, int perPage) {
		Map<String, Object> obj=new HashMap<String, Object>();
		obj.put("keyword", keyword);
		obj.put("start", start);
		obj.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getSearchCourseByLike(obj);
		return list;
	}

	@Override
	public List<JoinCourseDto> getCustomCourseByTime(String who, String during, String how, int start, int perPage) {
		Map<String, Object> obj=new HashMap<String, Object>();
		obj.put("who", who);
		obj.put("during", during);
		obj.put("how", how);
		obj.put("start", start);
		obj.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getCustomCourseByTime(obj);
		return list;
	}

	@Override
	public List<JoinCourseDto> getCustomCourseByLike(String who, String during, String how, int start, int perPage) {
		Map<String, Object> obj=new HashMap<String, Object>();
		obj.put("who", who);
		obj.put("during", during);
		obj.put("how", how);
		obj.put("start", start);
		obj.put("perPage", perPage);
		List<JoinCourseDto> list=joinCourseMapper.getTagCourseByTime(obj);
		return list;
	}

	@Override
	public CourseDto getCourseData(int courseNum) {
		return courseMapper.getCourseData(courseNum);
	}

	@Override
	public List<JoinCourseDto> getCourseDetail(int courseNum) {
		List<JoinCourseDto> list=joinCourseMapper.getCourseDetail(courseNum);
		return list;
	}

}
