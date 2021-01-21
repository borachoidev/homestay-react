package com.bitcamp.korea_tour.model.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitcamp.korea_tour.model.JoinCourseDto;

import lombok.extern.slf4j.Slf4j;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class JoinCourseMapperTest {
	
	@Autowired JoinCourseMapper joinCourseMapper;
	
	@Test
	void test() {
		List<JoinCourseDto> list = joinCourseMapper.getList();
		assertEquals(list.size(),11 );
		log.info("list size: " + list.size());
		
	}

}
