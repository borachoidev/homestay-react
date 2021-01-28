package com.bitcamp.korea_tour.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.korea_tour.model.AdminDto;
import com.bitcamp.korea_tour.model.mapper.AdminMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	private final AdminMapper adminMapper;
	
	@Override
	public void insertAdmin(AdminDto adminDto) {
		adminMapper.insertAdmin(adminDto);
	}
	
	@Override
	public List<AdminDto> getAllAdmin() {
		return adminMapper.getAllAdmin();
	}
	
	@Override
	public void deleteAdmin(int adminNum) {
		adminMapper.deleteAdmin(adminNum);
	}
	
	@Override
	public int checkAdmin(AdminDto adminDto) {
		return adminMapper.checkAdmin(adminDto);
	}
}
