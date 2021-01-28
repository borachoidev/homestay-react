package com.bitcamp.korea_tour.model.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JoinCourseSearchMapperTest {
	@Autowired
	private JoinCourseSearchMapper mapper;
	
	@Test
	void test() {
		//System.out.println(mapper.getSearchTotalCount("둘"));
	}

}
