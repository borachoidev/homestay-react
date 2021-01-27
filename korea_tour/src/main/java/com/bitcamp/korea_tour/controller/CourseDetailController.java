package com.bitcamp.korea_tour.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.CourseLikeDto;
import com.bitcamp.korea_tour.model.CourseMarkDto;
import com.bitcamp.korea_tour.model.JoinCourseDetailDto;
import com.bitcamp.korea_tour.model.service.course.CourseLikeService;
import com.bitcamp.korea_tour.model.service.course.CourseMarkService;
import com.bitcamp.korea_tour.model.service.course.JoinCourseDetailService;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CourseDetailController {
	private final JoinCourseDetailService joincourseDetailService;
	private final CourseLikeService cls;
	private final CourseMarkService cms;


	/**
	 * @param courseNum
	 * @return 메인코스 디테일
	 */
	@GetMapping(value="/courses/{courseNum}")
	public JsonDataList getCourseDetail(
			@PathVariable(value="courseNum") int courseNum
			) {

		CourseDto courseDto=joincourseDetailService.getCourseData(courseNum);
		List<JoinCourseDetailDto> coursePlaceList=joincourseDetailService.getCourseDetail(courseNum);
		int markTotalCount=joincourseDetailService.getCourseMarkTotal(courseNum);
		int likeTotalCount=joincourseDetailService.getCourseLikeTotal(courseNum);
		List<CourseMarkDto> courseMark=joincourseDetailService.getCourseMark(courseNum);
		List<CourseLikeDto> courseLike=joincourseDetailService.getCourseLike(courseNum);
		List<Integer> courseMarkNum=new ArrayList<Integer>();
		List<Integer> courseLikeNum=new ArrayList<Integer>();
		for(CourseMarkDto m:courseMark) {
			courseMarkNum.add(m.getCourseMarkNum());
		}
		for(CourseLikeDto l:courseLike) {
			courseLikeNum.add(l.getLikeNum());
		}
		List<List<Integer>> numList=new ArrayList<List<Integer>>();
		numList.add(courseMarkNum);
		numList.add(courseLikeNum);

		MarkLikeData markLikeData=new MarkLikeData(markTotalCount, likeTotalCount, numList);

		return new JsonDataList(courseDto, coursePlaceList, markLikeData);
	}
	
	/**
	//디테일페이지에서 코스 좋아요하기
	 * @param dto
	 */
	@PostMapping(value = "/courselikes")
	public void insertCourseLike(@RequestBody CourseLikeDto dto) {
		cls.insertCourseLike(dto);
	}
	
	/**
	//디테일페이지에서 좋아요 취소
	 * @param likeNum
	 */
	@DeleteMapping(value = "/courselikes/{likeNum}")
	public void deleteLike(@PathVariable(value = "likeNum") int likeNum) {
		cls.deleteCourseLike(likeNum);
	}

	/**
	//디테일페이지에서 즐겨찾기하기
	 * @param dto
	 */
	@PostMapping(value = "/coursemarks")
	public void insertCourseMark(@RequestBody CourseMarkDto dto) {
		cms.insertCourseMark(dto);
	}
	
	/**
	//디테일페이지에서 즐겨찾기 취소 
	 * @param courseMarkNum
	 */
	@DeleteMapping(value = "/coursemarks/{courseMarkNum}")
	public void deleteMark(@PathVariable int courseMarkNum) {
		cms.deleteCourseMark(courseMarkNum);
	}
	
	
	
	@Data
	@AllArgsConstructor
	static class JsonDataList {
		private CourseDto courseDto; //dto
		private List<JoinCourseDetailDto> coursePlaceList;  //list
		private MarkLikeData markLikeData;
	}

	@Data
	@AllArgsConstructor
	static class MarkLikeData {
		private int markTotalCount; //즐겨찾기 개수
		private int likeTotalCount; //좋아요 개수
		private List<List<Integer>> numList;
	}


}
