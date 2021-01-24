package com.bitcamp.korea_tour.model.service.course;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

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
		
		log.info("getAllCourseByTime: "+joinCourseService.getAllCourseByTime(0, 10));
		log.info("getAllCourseByLike: "+joinCourseService.getAllCourseByLike(0, 10));
		log.info("getMyCourseList :"+joinCourseService.getMyCourseList(7, 0, 10));
		log.info("getMyCourseDetail:"+joinCourseService.getMyCourseDetail(2, 7));
		log.info("getMyMarkCourse: "+joinCourseService.getMyMarkCourse(7, 0, 10));
		log.info("getTagCourseByTime: "+joinCourseService.getTagCourseByTime("w1", 0, 10));
		log.info("getTagCourseByLike: "+joinCourseService.getTagCourseByLike("w1", 0, 10));
		log.info("getSearchCourseByTime: "+joinCourseService.getSearchCourseByTime("둘이", 0, 10));
		log.info("getSearchCourseByLike: "+joinCourseService.getSearchCourseByLike("둘이", 0, 10));
		log.info("getCustomCourseByTime"+joinCourseService.getCustomCourseByTime("둘", "모레", "글쎄", 0, 10));
		log.info("getCustomCourseByLike"+joinCourseService.getCustomCourseByLike("둘", "모레", "글쎄", 0, 10));
		log.info("getCourseDetail: "+joinCourseService.getCourseDetail(55));
	}

}
