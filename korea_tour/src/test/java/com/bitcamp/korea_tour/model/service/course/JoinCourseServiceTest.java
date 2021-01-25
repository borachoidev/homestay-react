package com.bitcamp.korea_tour.model.service.course;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.CourseLikeDto;
import com.bitcamp.korea_tour.model.CourseMarkDto;
import com.bitcamp.korea_tour.model.JoinCourseDto;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class JoinCourseServiceTest {
	@Autowired
	//private JoinCourseService joinCourseService;
	
	@Test
	void test() {
//		CourseDto courseDto = new CourseDto();
//		courseDto.setContent("asdfasdf");
//		CourseDto courseDto = new CourseDto();
//		courseDto.setContent("asdfasdf");
//		CourseDto courseDto = new CourseDto();
//		courseDto.setContent("asdfasdf");
//		CourseDto courseDto = new CourseDto();
//		courseDto.setContent("asdfasdf");
//		CourseDto courseDto = new CourseDto();
//		courseDto.setContent("asdfasdf");
//		CourseDto courseDto = new CourseDto();
//		courseDto.setContent("asdfasdf");
//		CourseDto courseDto = new CourseDto();
//		courseDto.setContent("asdfasdf");
//		List<CourseDto> list = new ArrayList<CourseDto>();
//		list.add(courseDto);
				
				
//		List<JoinCourseDto> getMyCourseList(int loginNum, int start, int perPage);  //세션 로그인num 받아오기
//		List<JoinCourseDto> getMyMarkCourse(int loginNum, int start, int perPage);  //세션 로그인num 받아오기
//		List<JoinCourseDto> getTagCourseByTime(String tag, int start, int perPage);
//		List<JoinCourseDto> getTagCourseByLike(String tag, int start, int perPage);
//		List<JoinCourseDto> getSearchCourseByTime(String keyword, int start, int perPage);
//		List<JoinCourseDto> getSearchCourseByLike(String keyword, int start, int perPage);
//		List<JoinCourseDto> getCustomCourseByTime(String who, String during, String how, int start, int perPage);
//		List<JoinCourseDto> getCustomCourseByLike(String who, String during, String how, int start, int perPage);
//		CourseDto getCourseData(int courseNum); //디테일에서 출력할 코스내용
//		List<JoinCourseDto> getCourseDetail(int courseNum);
//		
//		<sql id="courseA">
//		SELECT * FROM course 
//		INNER JOIN coursePlace ON course.courseNum=coursePlace.courseNum 
//		INNER JOIN place ON place.contentId=coursePlace.contentId
//	</sql>
//	<sql id="courseB">
//		SELECT * FROM coursePlace 
//		INNER JOIN place ON place.contentId=coursePlace.contentId
//	</sql>
//	<sql id="courseC">
//		SELECT * FROM courseMark 
//		LEFT JOIN course ON courseMark.courseNum=course.courseNum
//		LEFT JOIN coursePlace ON course.courseNum=coursePlace.courseNum 
//		LEFT JOIN place ON place.contentId=coursePlace.contentId 
//	</sql>
//	
//	<!-- mypage 기준 -->
//	<!-- 내코스 목록보기 ->(사진은 어차피 1번만가져오면 되니까 orderNum으로 구분) -->
//	<select id="getMyCourseList" parameterType="hashmap" resultType="joincourse">
//		<include refid="courseA"/>
//		WHERE coursePlace.orderNum=1 AND course.userNum=#{loginNum} ORDER BY course.courseNum LIMIT #{start},#{perPage}
//	</select>
//
//
//	<!-- 내 즐겨찾기 코스 모아보기 ->userNum으로 내 즐겨찾기만 모아볼수 있도록(사진은 어차피 1번만가져오면 되니까 orderNum으로 구분) -->
//	<select id="getMyMarkCourse" resultType="joincoursemark" parameterType="HashMap">
//		<include refid="courseC"/>
//		WHERE courseMark.loginNum=#{loginNum} AND coursePlace.orderNum=1 ORDER BY courseMark.courseMarkNum LIMIT #{start},#{perPage}
//	</select>
//	
//	<!-- main페이지 기준 -->
//	
//	<!-- Nav로 태그 검색한 코스보기(최신순) -->
//	<select id="getTagCourseByTime" resultType="joincourse" parameterType="HashMap">
//		<include refid="courseA"/>
//		WHERE coursePlace.orderNum=1 AND course.open=1 AND course.who like #{tag} OR course.during like #{tag} OR course.how like #{tag} ORDER BY course.courseNum DESC LIMIT #{start},#{perPage}
//	</select>
//	
//	<!-- Nav로 태그 검색한 코스보기(인기순) -->
//	<select id="getTagCourseByLike" resultType="joincourse" parameterType="HashMap">
//		<include refid="courseA"/>
//		WHERE coursePlace.orderNum=1 AND course.open=1 AND course.who like #{tag} OR course.during like #{tag} OR course.how like #{tag} ORDER BY course.totalLike DESC LIMIT #{start},#{perPage}
//	</select>
//	
//	<!-- 통합검색코스(검색어에 해당하는 관광지가 들어있는 코스까지) 검색쿼리 최신순-->
//	<select id="getSearchCourseByTime" parameterType="HashMap" resultType="joincourse">
//		<include refid="courseA"/>
//        WHERE coursePlace.orderNum = 1 AND course.open=1
//        AND course.name LIKE CONCAT('%', #{keyword}, '%') OR course.content LIKE CONCAT('%', #{keyword}, '%')
//        OR place.title LIKE CONCAT('%', #{keyword}, '%') OR place.addr1 LIKE CONCAT('%', #{keyword}, '%')
//        order by course.courseNum DESC LIMIT #{start},#{perPage}
//	</select>
//	
//	<!-- 통합검색코스(검색어에 해당하는 관광지가 들어있는 코스까지) 검색쿼리 인기순-->
//	<select id="getSearchCourseByLike" parameterType="HashMap" resultType="joincourse">
//		<include refid="courseA"/>
//       	WHERE coursePlace.orderNum = 1 AND course.open=1
//        AND course.name LIKE CONCAT('%', #{keyword}, '%') OR course.content LIKE CONCAT('%', #{keyword}, '%')
//        OR place.title LIKE CONCAT('%', #{keyword}, '%') OR place.addr1 LIKE CONCAT('%', #{keyword}, '%')
//        order by course.totalLike DESC LIMIT #{start},#{perPage}
//	</select>
//	
//	<!-- 맞춤코스 검색(최신순) -->
//	<select id="getCustomCourseByTime" parameterType="hashmap" resultType="joincourse">
//		<include refid="courseA"/>
//		WHERE coursePlace.orderNum=1 AND course.open=1
//        AND course.who LIKE CONCAT('%', #{who}, '%') AND course.during LIKE CONCAT('%', #{during}, '%') AND course.how LIKE CONCAT('%', #{how}, '%')
//        ORDER BY course.courseNum DESC LIMIT #{start},#{perPage}
//	</select>
//	
//	<!-- 맞춤코스 검색(인기순) -->
//	<select id="getCustomCourseByLike" parameterType="hashmap" resultType="joincourse">
//		<include refid="courseA"/>
//		WHERE coursePlace.orderNum=1 AND course.open=1
//        AND course.who LIKE CONCAT('%', #{who}, '%') AND course.during LIKE CONCAT('%', #{during}, '%') AND course.how LIKE CONCAT('%', #{how}, '%')
//        ORDER BY course.totalLike DESC LIMIT #{start},#{perPage}
//	</select>
//	
//	<!-- 메인페이지 코스 자세히보기 -->
//	<select id="getCourseDetail" parameterType="int" resultType="joincoursedetail">
//		<include refid="courseB"/>
//		WHERE coursePlace.courseNum=#{courseNum}
//	</select>
		
		
//		assertEquals(joinCourseService.getAllCourseByTime(0, 10).size(), 2);
//		assertEquals(joinCourseService.getAllCourseByLike(0, 10).size(), 2);
//		assertEquals(joinCourseService.getMyCourseData(2, 7).getName(), "둘이서");
//		assertEquals(joinCourseService.getCourseMark(2).size(), 3);
//		assertEquals(joinCourseService.getCourseLike(100).size(), 3);
//		assertEquals(joinCourseService.getMyCourseDetail(2, 7).size(), 2);
//		assertEquals(joinCourseService.getMyCourseList(7, 0, 10).size(), 1);
	}

}
