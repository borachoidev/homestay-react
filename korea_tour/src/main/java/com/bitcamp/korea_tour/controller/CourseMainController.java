package com.bitcamp.korea_tour.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	
	int start;
	int perPage;
	int totalCount;
	
	/**
	 * @param currentPage
	 * @return 전체 코스 목록
	 */
	@GetMapping(value="/courses/{sortType}/{currentPage}")
	public JsonData<List<JoinCourseDto>> getAllCourse(
			@PathVariable(name="sortType") String sortType, 
			@PathVariable(name="currentPage") int currentPage
			) {
		
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
	
	/**
	 * @param sortType
	 * @param currentPage
	 * @param tag
	 * @return nav태그 검색 목록
	 */
	@GetMapping(value="/courses/tag/{sortType}/{currentPage}/{tag}")
	public JsonData<List<JoinCourseDto>> getTagCourse(
			@PathVariable(value="sortType") String sortType, 
			@PathVariable(value="currentPage") int currentPage,
			@PathVariable(value="tag") String tag
			) {
		List<JoinCourseDto> list=new ArrayList<JoinCourseDto>();
		
		totalCount=joinCourseSearchService.getTagTotalCount(tag);
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		
			if(sortType.equals("time")) {
				list=joinCourseSearchService.getTagCourseByTime(tag, start, perPage);
			}else if(sortType.equals("like")) {
				list=joinCourseSearchService.getTagCourseByLike(tag, start, perPage);
			}
			
		return new JsonData<List<JoinCourseDto>>(list);
	}

	/**
	 * @param sortType
	 * @param currentPage
	 * @param keyword
	 * @return 통합 검색 결과
	 */
	@GetMapping(value="/courses/search/{sortType}/{currentPage}/{keyword}")
	public JsonData<List<JoinCourseDto>> getSearchCourse(
		@PathVariable(value="sortType") String sortType, 
		@PathVariable(value="currentPage") int currentPage,
		@PathVariable(value="keyword") String keyword
			) {
		totalCount=joinCourseSearchService.getSearchTotalCount(keyword);
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		
		List<JoinCourseDto> list=new ArrayList<JoinCourseDto>();
		
		if(sortType.equals("time")) {
			list=joinCourseSearchService.getSearchCourseByTime(keyword, start, perPage);
		}else if(sortType.equals("like")) {
			list=joinCourseSearchService.getSearchCourseByLike(keyword, start, perPage);
		}
		
		return new JsonData<List<JoinCourseDto>>(list);
	}
	
	/**
	 * @param sortType
	 * @param currentPage
	 * @param who
	 * @param during
	 * @param how
	 * @return 맞춤 코스 검색 결과
	 */
	@GetMapping(value="/courses/custom/{sortType}/{currentPage}/{who}/{during}/{how}")
	public JsonData<List<JoinCourseDto>> getCustomCourse(
		@PathVariable(value="sortType") String sortType, 
		@PathVariable(value="currentPage") int currentPage,
		@PathVariable(value="who") String who,
		@PathVariable(value="during") String during,
		@PathVariable(value="how") String how
			) {
		totalCount=joinCourseSearchService.getCustomTotalCount(who, during, how);
		start=pagingService.getPagingData(totalCount, currentPage).get("start");
		perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		
		List<JoinCourseDto> list=new ArrayList<JoinCourseDto>();
		
		if(sortType.equals("time")) {
			list=joinCourseSearchService.getCustomCourseByTime(who, during, how, start, perPage);
		}else if(sortType.equals("like")) {
			list=joinCourseSearchService.getCustomCourseByLike(who, during, how, start, perPage);
		}
		
		return new JsonData<List<JoinCourseDto>>(list);
	}

	/**
	 * 
	 * @param loginNum
	 * @return
	 */
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
