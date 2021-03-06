package com.yheeing.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yheeing.webservice.PostsService;
import com.yheeing.webservice.domain.posts.PostsRepository;
import com.yheeing.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

//	private PostsRepository postsRepository;
	private PostsService postsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
//		postsRepository.save(dto.toEntity());
		postsService.Save(dto);
	}
}
