package com.bitcamp.korea_tour.model.service.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class JoinCourseServiceTest {
	@Autowired
	private JoinCourseService joinCourseService;
	
	@Test
	void test() {
		
		log.info("courseList: "+joinCourseService.getCourseDetail(55));
	}

}
