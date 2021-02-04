package com.bitcamp.korea_tour.controller.restapi.homestay;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.korea_tour.fileupload.SpringFileWriter;
import com.bitcamp.korea_tour.model.homestay.HomeStayPhotoDto;
import com.bitcamp.korea_tour.model.homestay.JoinHomeStayDetailDto;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayHostPhotoService;
import com.bitcamp.korea_tour.model.service.homestay.HomeStayHostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeStayHostController {
	private final HomeStayHostService hsas;
	private final HomeStayHostPhotoService hshps;
	
	@PutMapping("/homestay/house/{homeStayNum}")
	public void updateHouse(
			@PathVariable(value = "homeStayNum") int homeStayNum,
			@RequestBody JoinHomeStayDetailDto dto) {
		hsas.updateHomeStay(dto, homeStayNum);
		hsas.updateHomeStayDetail(dto, homeStayNum);
	}
	
	@PostMapping("/homestay/photo/{userNum}")
	public void insertPhoto(
			@PathVariable(value = "userNum") int userNum,
			/* @RequestParam int homeStayNum, */
			@RequestParam List<MultipartFile> images,
			HttpServletRequest request
			) {
		String path = request.getSession().getServletContext().getRealPath("/homeStayImg");
		SpringFileWriter writer = new SpringFileWriter(); 
		String upload = "";
		for(MultipartFile file: images) {
			if(file.getOriginalFilename().length() == 0) {
				upload = "no";
				break;			
			}
			
			upload = writer.changeFilename(file.getOriginalFilename());
			writer.writeFile(file, upload, path);
			
			int homeStayNum = hsas.getHomeStayNum2(userNum);
			HomeStayPhotoDto dto = new HomeStayPhotoDto();
			dto.setPhotoName(upload);
			dto.setUserNum(userNum);
			dto.setHomeStayNum(homeStayNum);
			hshps.insertPhoto(dto);
		}
	}
	
	
}
