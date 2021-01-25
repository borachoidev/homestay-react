package com.bitcamp.korea_tour.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.JoinCourseDto;
import com.bitcamp.korea_tour.model.service.course.JoinCourseMainService;
import com.bitcamp.korea_tour.model.service.course.JoinCourseSearchService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController 
@RequiredArgsConstructor
public class CourseMainController {
	private final PagingService pagingService;
	private final JoinCourseMainService joinCourseMainService;
	private final JoinCourseSearchService joinCourseSearchService;
	
	/**
	 * @param currentPage
	 * @return 전체 코스 목록
	 */
	@GetMapping(value="/courses/{sortType}/{currentPage}")
	public JsonData<List<JoinCourseDto>> getAllCourse(
			@PathVariable(value="sortType") String sortType, 
			@PathVariable(value="currentPage") int currentPage
			) {
		int totalCount;
		int start;
		int perPage;
		
		totalCount=joinCourseMainService.getAllTotalCount();
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		
		List<JoinCourseDto> list=new ArrayList<JoinCourseDto>();
		
		if(sortType.equals("time")) {
			list=joinCourseMainService.getAllCourseByTime(start, perPage);
		}else if(sortType.equals("like")) {
			list=joinCourseMainService.getAllCourseByLike(start, perPage);
		}
		return new JsonData<List<JoinCourseDto>>(list);
	}
	
	@GetMapping(value="/courses/{searchType}/{sortType}/{currentPage}")
	public JsonData<List<JoinCourseDto>> getSearchCourse(
			@PathVariable(value="searchType") String searchType,
			@PathVariable(value="sortType") String sortType, 
			@PathVariable(value="currentPage") int currentPage,
			@ModelAttribute SearchDto searchDto
			) {
		int start;
		int perPage;
		int totalCount;
		List<JoinCourseDto> list=new ArrayList<JoinCourseDto>();
		
		String tag=searchDto.getTag();
		System.out.println(tag);
		totalCount=joinCourseSearchService.getTagTotalCount(tag);
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		System.out.println(totalCount);
		System.out.println(start);
		System.out.println(perPage);
		if(searchType.equals("tag")) {
			
			
			if(sortType.equals("time")) {
				list=joinCourseSearchService.getTagCourseByTime(tag, start, perPage);
			}else if(sortType.equals("like")) {
				list=joinCourseSearchService.getTagCourseByLike(tag, start, perPage);
			}
			
		}else if(searchType.equals("search")) {
			
			String keyword=searchDto.getKeyword();
			totalCount=joinCourseSearchService.getSearchTotalCount(keyword);
			start=pagingService.getPagingData(totalCount, currentPage).get("start");
			perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
			
			if(sortType.equals("time")) {
				list=joinCourseSearchService.getTagCourseByTime(keyword, start, perPage);
			}else if(sortType.equals("like")) {
				list=joinCourseSearchService.getSearchCourseByLike(keyword, start, perPage);
			}
			
		}else if(searchType.equals("custom")) {
			
			String who=searchDto.getWho();
			String during=searchDto.getDuring();
			String how=searchDto.getHow();
			totalCount=joinCourseSearchService.getCustomTotalCount(who, during, how);
			start=pagingService.getPagingData(totalCount, currentPage).get("start");
			perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
			
			if(sortType.equals("time")) {
				list=joinCourseSearchService.getCustomCourseByTime(who, during, how, start, perPage);
			}else if(sortType.equals("like")) {
				list=joinCourseSearchService.getCustomCourseByLike(who, during, how, start, perPage);
			}
			
		}
		return new JsonData<List<JoinCourseDto>>(list);
	}
	
	@GetMapping(value="/courses")
	public JsonData<List<CourseName>> getCourseNameList(
			@RequestParam(value="loginNum") int loginNum
			) {

		List<CourseDto> course=joinCourseMainService.getMyCourseName(loginNum);
		
		List<CourseName> list=new ArrayList<CourseName>();

		for(CourseDto c:course) {
			CourseName courseName=new CourseName(c.getCourseNum(), c.getName());
			list.add(courseName);
		}
		
		return new JsonData<List<CourseName>>(list);
	}
	
	
	@Data
	@AllArgsConstructor
	static class JsonData<T> {
		private T list;
	}
	
	@Data
	@AllArgsConstructor
	static class SearchDto {
		private String tag;
		private String keyword;
		private String who;
		private String during;
		private String how;
	}
	
	@Data
	@AllArgsConstructor
	static class CourseName {
		private int courseNum;
		private String courseName;
	}
	
}
