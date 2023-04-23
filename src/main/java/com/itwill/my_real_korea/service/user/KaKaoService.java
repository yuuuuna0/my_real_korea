package com.itwill.my_real_korea.service.user;

import java.io.IOException;
import java.net.URI;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itwill.my_real_korea.dto.user.KakaoProfile;

@Service
public class KaKaoService {
	/***************************************************
	 * 인가코드로 토큰받기
	 *****************************************************/
	@Value("${api.kakao.rest_api_key}")
	private String kakaoRestApiKey;

	@Value("${api.kakao.javascript_key}")
	private String kakaoJavascriptApiKey;
	
	@Value("${api.kakao.redirect_url}")
	private String redirect_url;

	public String getToken(String code) throws IOException {	//authorize code로 token을 얻는 행위 (모든 api 공통)
		String kakaoAuthUrl = "https://kauth.kakao.com";
		String reqUrl = "/oauth/token";
		String accessToken = "";

		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create(kakaoAuthUrl + reqUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Accept", "application/json");
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		parameters.set("grant_type", "authorization_code");
		parameters.set("client_id", kakaoRestApiKey);
		parameters.set("redirect_uri", redirect_url);
		parameters.set("code", code);	//인증코드
		HttpEntity<MultiValueMap<String, Object>> restRequest = new HttpEntity<>(parameters, headers);
		//http요청 
		ResponseEntity<JSONObject> apiResponse = restTemplate.postForEntity(uri, restRequest, JSONObject.class);
		JSONObject responseBody = apiResponse.getBody();
		System.out.println(">> getToken responseBody : "+responseBody);	//access_token key값
		accessToken = (String) responseBody.get("access_token");
		return accessToken;
	}

	/*********************************************
	 * 카카오아이디얻기
	 *********************************************/
	public String getKakaoId(String accessToken) throws Exception {	
		//access token으로 id 얻는 작업. 내 db에 존재하면 로그인, 존재하지 않으면 회원가입 redirection
		String kakaoUniqueNo = "";
		String kakaoApiUrl = "https://kapi.kakao.com";
		// restTemplate을 사용하여 API 호출
		RestTemplate restTemplate = new RestTemplate();
		String reqUrl = "/v2/user/me";
		URI uri = URI.create(kakaoApiUrl + reqUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "bearer " + accessToken);
		headers.set("KakaoAK", kakaoRestApiKey);

		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();

		HttpEntity<MultiValueMap<String, Object>> restRequest = new HttpEntity<>(parameters, headers);
		ResponseEntity<JSONObject> apiResponse = restTemplate.postForEntity(uri, restRequest, JSONObject.class);
		JSONObject responseBody = apiResponse.getBody();
		kakaoUniqueNo = (Long) responseBody.get("id") + "";
		System.out.println(">> getKakaoId kakaoUniqueNo : "+kakaoUniqueNo);
		return kakaoUniqueNo;
	}

	/*********************************************
	 * 카카오유저정보얻기
	 *********************************************/
	public KakaoProfile getKakaoProfile(String accessToken) throws Exception {
		String kakaoApiUrl = "https://kapi.kakao.com";
		
		RestTemplate restTemplate = new RestTemplate();
		String reqUrl = "/v2/user/me";
		URI uri = URI.create(kakaoApiUrl + reqUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "bearer " + accessToken);	//한칸 띄어야됨
		headers.set("KakaoAK", kakaoRestApiKey);
		MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(parameters, headers);
		ResponseEntity<String> kakaoResponseEntity = restTemplate.postForEntity(uri, entity, String.class);
		String kakaoProfileStr = kakaoResponseEntity.getBody();
		System.out.println(">> getKakaoProfile : "+kakaoProfileStr);
		
		ObjectMapper objectMapper = new ObjectMapper();
		KakaoProfile kakaoProfile = objectMapper.readValue(kakaoProfileStr, KakaoProfile.class);
		System.out.println(">> 카카오 아이디(번호) : " + kakaoProfile.getId());
		System.out.println(">> 카카오 이메일 : " + kakaoProfile.getKakao_account().getEmail());

		return kakaoProfile;
	}

}
