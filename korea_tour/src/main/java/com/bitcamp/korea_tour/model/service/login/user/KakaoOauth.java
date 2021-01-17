package com.bitcamp.korea_tour.model.service.login.user;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KakaoOauth implements OauthService{
//	private final String aa;
	
	
	
	@Override
	public String getOauthRedirectURL() {
		return "";
	}

	@Override
	public String requestAccessToken(String code) {
		// TODO Auto-generated method stub
		return "";
	}
}
