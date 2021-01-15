package com.bitcamp.korea_tour.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.mapper.UserMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService,SessionNames {
	
	private UserMapper mapper;
	
	@Override
	public void getUserList(Model model) {
		
		mapper.getUserList();

	}

	@Override
	public void insertUser(UserDto dto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		mapper.insertUser(dto);
		session.setAttribute(USER, dto);
		
	}

	@Override
	public void getUserData(String userNum, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userNum) {

	}
	
	@Override
	public String getKakaoToken(String code) {
		
		String accessToken="";
		String refreshToken="";
		String reqURL="https://kauth.kakao.com/oauth/token";
		
		try {
			URL url=new URL(reqURL);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			
			//post요청을 위해 기본값이 false인 setDoOutput을 true로 
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			//post요청시 요구하는 파라미터 스트림을 전송
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb=new StringBuilder();
			sb.append("grant_type=autorization_code");
			sb.append("&client_id=5d2136e7d58ec45f7275dcd5dd09cf7c");
			sb.append("&redirect_uri=http://localhost:9003/login");
			sb.append("&code="+code);
			bw.write(sb.toString());
			bw.flush();
			
			//결과 코드가 200이면 성공
			int responseCode=conn.getResponseCode();
			System.out.println("responseCode: "+responseCode);
			
			//요청을 통해 얻은 JSON타입의 response메세지 읽어오기
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line="";
			String result="";
			
			while((line=br.readLine())!=null) {
				result+=line;
			}
			
			System.out.println("responseBody: "+result);
			
			//JSON파싱 객체 생성(Gson 라이브러리)
			JsonParser parser=new JsonParser();
			JsonElement element=parser.parse(result);
			
			accessToken=element.getAsJsonObject().get("access_token").getAsString();
			refreshToken=element.getAsJsonObject().get("refresh_token").getAsString();
			
			System.out.println("accessToken: "+accessToken);
			System.out.println("refreshToken: "+refreshToken);
			
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return accessToken;
	}
	
	@Override
	public UserDto getKakaoInfo(String token) {
		
		UserDto dto=new UserDto();
		String reqURL="https://kapi.kakao.com/v2/user/me";
		
		URL url;
		try {
			url = new URL(reqURL);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			
			//요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer"+token);
			
			int responseCode=conn.getResponseCode();
			System.out.println("responseCode: "+responseCode);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line="";
			String result="";
			
			while((line=br.readLine())!=null) {
				result+=line;
			}
			
			System.out.println("responseBody: "+result);
			
			JsonParser parser=new JsonParser();
			JsonElement element=parser.parse(result);

			JsonObject id=element.getAsJsonObject().get("id").getAsJsonObject();
			JsonObject properties=element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakaoAccount=element.getAsJsonObject().get("kakao_account").getAsJsonObject();
			
			String email=kakaoAccount.getAsJsonObject().get("email").getAsString();
			String name=properties.getAsJsonObject().get("nickname").getAsString();
			String birth=properties.getAsJsonObject().get("custom_field1").getAsString();
			String gender=kakaoAccount.getAsJsonObject().get("gender").getAsString();
			String photo=properties.getAsJsonObject().get("profile_image").getAsString();
			String kakaoKey=id.getAsJsonObject().getAsString();
			
			dto.setEmail(email);
			dto.setName(name);
			dto.setBirth(birth);
			dto.setGender(gender);
			dto.setPhoto(photo);
			dto.setKakaoKey(kakaoKey);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	@Override
	public boolean hasKey(String sns,String key) {
		
		if(sns.equals("kakao")) {
			if(mapper.hasKey(key)==0) {
				return true;
			}
		}else if(sns.equals("naver")) {
			
		}else {
			
		}
		
		return false;
	}
	
}
