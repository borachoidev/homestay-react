package com.bitcamp.korea_tour.model.service.paging;

import java.util.List;
import java.util.Map;

import com.bitcamp.korea_tour.model.JoinCourseDto;
import com.bitcamp.korea_tour.model.UserDto;

public interface PagingService {
	
	/*
	 페이징 필요한 뷰
		1. 코스목록(최신순/좋아요순)
		2. 관광지 목록(최신순/좋아요순)
		3. 검색 목록(최신순/ 좋아요순)
		4. 태그검색목록(최신순/ 좋아요순)
		5. 마이페이지(코스목록/즐겨찾기목록/댓글목록/답글목록)
		6. 관리자페이지(호스트목록/댓글목록/답글목록/회원목록)
	*/
	List<JoinCourseDto> getAllCourseByTime();
	List<JoinCourseDto> getAllCourseByLike();
	List<JoinCourseDto> getTagCourseByTime();
	List<JoinCourseDto> getTagCourseByLike();
	List<JoinCourseDto> getMyCourseList();
	List<JoinCourseDto> getMyMarkCourse();
	List<UserDto> getUserList();
	int getTotalCount(List<Object> pageingList);
	void dealPaging(String page);
}
