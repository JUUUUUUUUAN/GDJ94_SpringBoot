package com.winter.app.ajax;


import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.nimbusds.jose.shaded.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AjaxTest1 {
	
	public void t3() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new org.springframework.http.HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Content-type", "application/json; charset=UTF-8");
		
//		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//		params.add("title", "title");
//		params.add("body", "body");
//		params.add("userId", "1");
		
		PostDTO postDTO = new PostDTO();
		postDTO.setTitle("title");
		postDTO.setBody("body");
		postDTO.setUserId(5);
		
		HttpEntity<PostDTO> req = new HttpEntity<>(postDTO,headers);
		
		postDTO = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", req, PostDTO.class);
		log.info("{}",postDTO);
	}
	
	public void t2() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		List<PostDTO> res = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", List.class);
		log.info("{}", res.get(5));
	}
	
	// 1. RestTamplate
	public void t1() throws Exception {
		//1. RestTamplate 객체 생성
		RestTemplate restTamplate = new RestTemplate();
		//2. Header 설정
		
		//3. parameter 설정
		
		ResponseEntity<PostDTO> res = restTamplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1",PostDTO.class);
		PostDTO postDTO = res.getBody();
		
		//PostDTO postDTO = restTamplate.getForObject("https://jsonplaceholder.typicode.com/posts/2", PostDTO.class);
		log.info("{}", postDTO);
	}
}
