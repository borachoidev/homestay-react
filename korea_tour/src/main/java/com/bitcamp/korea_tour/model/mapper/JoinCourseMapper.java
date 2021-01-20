package com.bitcamp.korea_tour.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitcamp.korea_tour.model.CourseDto;

@Mapper
public interface JoinCourseMapper {
	List<CourseDto> getList();
	CourseDto getData(int courseNum);
}
