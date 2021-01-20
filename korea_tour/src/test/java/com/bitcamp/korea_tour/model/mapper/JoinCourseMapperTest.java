package com.bitcamp.korea_tour.model.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitcamp.korea_tour.model.CourseDto;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class JoinCourseMapperTest {
	
	@Autowired JoinCourseMapper joinCourseMapper;
	
	
	@Test
	void test() {
		System.out.println(joinCourseMapper);
		System.out.println("aaaaa");
		List<CourseDto> list = joinCourseMapper.getList();
		
		list.stream()
			.forEach(System.out::println);
		System.out.println(list.size());
		assertEquals(list.size(),2 );
		
	}

}
