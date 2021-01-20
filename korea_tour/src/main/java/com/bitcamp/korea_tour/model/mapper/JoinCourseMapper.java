package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.JoinCourseDto;

@Mapper
public interface JoinCourseMapper {
	List<JoinCourseDto> getList();
	CourseDto getData(int courseNum);
}
