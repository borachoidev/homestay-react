package com.bitcamp.korea_tour.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import com.bitcamp.korea_tour.fileupload.SpringFileWriter;
import com.bitcamp.korea_tour.model.CourseDto;
import com.bitcamp.korea_tour.model.JoinPlaceListDto;
import com.bitcamp.korea_tour.model.PagingDto;
import com.bitcamp.korea_tour.model.PlaceApiPhotoDto;
import com.bitcamp.korea_tour.model.PlaceDto;
import com.bitcamp.korea_tour.model.PlacePhotoDto;
import com.bitcamp.korea_tour.model.TourAnswerDto;
import com.bitcamp.korea_tour.model.joinPlaceDto;
import com.bitcamp.korea_tour.model.service.JoinPlaceService;
import com.bitcamp.korea_tour.model.service.PlacePhotoService;
import com.bitcamp.korea_tour.model.service.paging.PagingService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PlaceController {

	private final JoinPlaceService service;
	private final PlacePhotoService service2;
	private final PagingService pagingService;
	int totalCount = 0;
	int start = 0;
	int perPage = 0;
	
	@Data
	@AllArgsConstructor
	static class JsonPlaceMain<T> {
		private T place;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonPlaceList {
		private List<JoinPlaceListDto> place;
		private int totalCount;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonPlaceDetail {
		private PlaceDto place;
		private List<PlaceApiPhotoDto> apiPhoto;
		private List<PlacePhotoDto> userPhoto;
		private List<TourAnswerDto> tourAnswer;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonCourseData {
		private List<HashMap<String, Object>> course;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonAdminPhotos {
		private List<PlacePhotoDto> photo;
	}
	
	@Data
	@AllArgsConstructor
	static class JsonPhotoRequest {
		private int contentId;
		private List<MultipartFile> image;
		private String loginId;
	}
	// 관광지 메인페이지 (4개 랜덤 출력)
	@GetMapping("/place")
	public JsonPlaceMain<List<PlaceDto>> getPlaceMain() { 
		List<PlaceDto> list = service.getFourDatasByRandom();
		return new JsonPlaceMain<List<PlaceDto>>(list);
	}
	
	// 관광지 리스트 제목순
	@GetMapping("/places/title/{currentPage}/{areaCode}")
	public JsonPlaceList getPlaceListBytitle(
			@PathVariable(name="currentPage") int currentPage,
			@PathVariable(name="areaCode") int areaCode){
//		System.out.println(currentPage + orderBy + areaCode);
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<JoinPlaceListDto> place = null;
		int totalCount = 0;
		map.put("orderBy", "title");
		map.put("areaCode", areaCode);
		if(areaCode!=100) { // 지역 검색
			totalCount = service.getTotalCountInArea(areaCode);
		}else { // 전국
			totalCount = service.getTotalCount();
		}
		int start=pagingService.getPagingData(totalCount, currentPage).get("start");
	    int perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		map.put("start", start);
		map.put("perPage", perPage);
//		System.out.println(map);
		if(areaCode==100) { // 지역 검색
			place = service.searchPlaceByTitleInNation(map);
		}else { // 전국
			place = service.searchPlaceByTitleInArea(map);
		}
//		System.out.println(place);
		return new JsonPlaceList(place, totalCount);
	}
	
	//관광지 리스트 좋아요순
	@GetMapping("/places/like/{currentPage}/{areaCode}")
	public JsonPlaceList getPlaceListByLike(
			@PathVariable(name="currentPage") int currentPage,
			@PathVariable(name="areaCode") int areaCode){
//		System.out.println(currentPage + orderBy + areaCode);
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<JoinPlaceListDto> place = null;
		int totalCount = 0;
		map.put("orderBy", "title");
		map.put("areaCode", areaCode);
		if(areaCode!=100) { // 지역 검색
			totalCount = service.getTotalCountInArea(areaCode);
		}else { // 전국
			totalCount = service.getTotalCount();
		}
		int start=pagingService.getPagingData(totalCount, currentPage).get("start");
	    int perPage=pagingService.getPagingData(totalCount, currentPage).get("perPage");
		map.put("start", start);
		map.put("perPage", perPage);
//		System.out.println(map);
		if(areaCode==100) { // 지역 검색
			place = service.searchPlaceByLikeInNation(map);
		}else { // 전국
			place = service.searchPlaceByLikeInArea(map);
		}
//		System.out.println(place);
		return new JsonPlaceList(place, totalCount);
	}
	
	// 관광지 디테일 페이지
	@GetMapping("/place/detail/{contentId}")
	public JsonPlaceDetail getPlaceDetailList(@PathVariable(name="contentId") int contentId) {
		PlaceDto place = service.getPlaceDetail(contentId);
		List<PlaceApiPhotoDto> apiPhoto = service.getPlaceDetailApiPhotos(contentId);
		List<PlacePhotoDto> userPhoto = service.getPlaceDetailPhotos(contentId);
		List<TourAnswerDto> tourAnswer = service.getAnswerOfPlace(contentId);
//		System.out.println(place);
//		System.out.println(apiPhoto);
//		System.out.println(userPhoto);
//		System.out.println(tourAnswer);
		return new JsonPlaceDetail(place, apiPhoto, userPhoto, tourAnswer);
	}
	
	// 코스 담기 클릭시 사용자 코스 전체 보기
	@GetMapping("/place/detail/course/{userNum}")
	public JsonCourseData getCourseByUser(@PathVariable(name="userNum") int userNum) {
		List<CourseDto> list = service.getCourseByUser(userNum);
		HashMap<String, Object> col = null;
		List<HashMap<String, Object>> course = new ArrayList<HashMap<String,Object>>();
		for(CourseDto dto: list) {
			col = new HashMap<String, Object>();
			col.put("courseNum", dto.getCourseNum());
			col.put("userNum", dto.getUserNum());
			col.put("name", dto.getName());
			course.add(col);
		}
		
		return new JsonCourseData(course);
	}
	
	// 사진 추가
	// realpath
	@PostMapping("/place/detail/photo")
	public void insertUserPhoto(
			@RequestBody JsonPhotoRequest paramList
			,HttpServletRequest request
			) {
		// 파일 업로드 경로
		String path = request.getSession().getServletContext().getRealPath("placeImg");
		System.out.println(path);
		SpringFileWriter writer = new SpringFileWriter();
		String upload = "";
		List<MultipartFile> files = paramList.getImage();
		int contentId = paramList.getContentId();
		String loginId = paramList.getLoginId();
		for(MultipartFile file: files) {
			// 업로드 안한경우 첫파일의 파일명이 빈문자열
			if(file.getOriginalFilename().length() == 0) {
				upload = "no";
				break;
			}
			
			upload = writer.changeFilename(file.getOriginalFilename());
			// 이미지 save 폴더에 저장
			writer.writeFile(file, upload, path);
			
			PlacePhotoDto dto = new PlacePhotoDto();
			dto.setContentId(contentId);
			dto.setImage(upload);
			dto.setLoginId(loginId);
			service2.insertData(dto);
		}
		
	}
	
	
	// 사진 삭제
	// realpath
	@DeleteMapping("/place/detail/photo/{photoNum}")
	public void deleteData(@PathVariable(name="photoNum") int photoNum) {
		service2.deleteData(photoNum);
	}
	
	// 관리자 사진 목록 조회
	@GetMapping("/admin/place/photo/{currentPage}")
	public JsonAdminPhotos getDisapprovedDatas(@PathVariable int currentPage) {
		int totalCount = service2.getTotalCount();
		Map<String, Integer> paging = pagingService.getPagingData(totalCount, currentPage);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start",paging.get("start"));
		map.put("perPage", paging.get("perPage"));
		List<PlacePhotoDto> photo = service2.getDisapprovedDatas(map);
		
		return new JsonAdminPhotos(photo);
	}
	
	// 관리자 사진 approval=1로 수정
	@PutMapping("/admin/place/photo/{photoNum}")
	public void approvePhoto(@PathVariable(name="photoNum") int photoNum) {
		service2.approvePhoto(photoNum);
	}
	
}
