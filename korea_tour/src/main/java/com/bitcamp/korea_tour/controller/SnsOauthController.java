package com.bitcamp.korea_tour.controller;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bitcamp.korea_tour.model.UserDto;
import com.bitcamp.korea_tour.model.service.login.setting.SnsLoginType;
import com.bitcamp.korea_tour.model.service.login.user.OauthResReq;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin 
@RequiredArgsConstructor
@RequestMapping(value="/login")
@Slf4j
public class SnsOauthController {
	
	private final OauthResReq oauthResReq;
	
	 /**
     * 사용자로부터 SNS 로그인 요청을 SnsLoginType 을 받아 처리
     * @param snsLoginType (GOOGLE, FACEBOOK, NAVER, KAKAO)
     */
    @GetMapping(value = "/{snsLoginType}")
    public void snsLoginType(
            @PathVariable(name = "snsLoginType") SnsLoginType snsLoginType) {
		log.info(">> 사용자로부터 SNS 로그인 요청을 받음 :: {} Social Login", snsLoginType);
		oauthResReq.request(snsLoginType);
    }
    
    /**
    *Social Login API Server 요청에 의한 callback 을 처리
    * @param socialLoginType (GOOGLE, NAVER, KAKAO)
    * @param code API Server 로부터 넘어오는 code
    * @return SNS Login 요청 결과로 받은 Json 형태의 String 문자열 (access_token, refresh_token 등)
    */
   @GetMapping(value = "/{snsLoginType}/callback")
   public String callback(
          @PathVariable(name = "snsLoginType") SnsLoginType snsLoginType, @RequestParam(name = "code") String code) {
	   
       log.info(">> 소셜 로그인 API 서버로부터 받은 code :: {}", code);
       
       if(snsLoginType.equals("google")) {
    	   
    	   // 구글 어카운트에서 REST API 통신을 하여 얻어온 JSON (accss_token,id_token .... ) : 스트링 타입이다.
    	   String googleJson = oauthResReq.requestAccessToken(snsLoginType, code);
    	   
    	   
    	   UserDto userInfo = getUserInfo(googleJson);  //getUserInfo 하는 방식은 다 다르니까 각 구현객체에서 만들어준다
    	   
    	   //키값 있으면 디비인서트 없이 그냥 바로 로그인(각 구현체에서 만들어주기) 
    	   
       }
       
  
     
       return "login";  //이렇게 못씀
       
   }		
		
   
   /**
    * 구글로옮기기
    * 암호화된 jwt param
    * 
    * @param googleJson
    * @return UserDto
    */
   
   private UserDto getUserInfo(String googleJson) {
	   
	   
	   JsonParser jsonParser = new JsonParser();
       JsonElement parse = jsonParser.parse(googleJson);
       JsonObject asJsonObject = parse.getAsJsonObject();
       
       //받아온 id_token이 JWT이므로 복호화하여 사용한다.
       JWT jwt = new JWT();
       DecodedJWT decodeJwt = jwt.decodeJwt(asJsonObject.get("id_token").getAsString());
       
       UserDto userDto = new UserDto();
       userDto.setName(decodeJwt.getClaims().get("name").asString());
       userDto.setGoogleKey(decodeJwt.getHeaderClaim("kid").asString());
       userDto.setPhoto(decodeJwt.getClaims().get("picture").asString());

       return userDto;
	   
   }
	
	
}
