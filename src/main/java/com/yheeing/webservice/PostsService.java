package com.yheeing.webservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yheeing.webservice.domain.posts.PostsRepository;
import com.yheeing.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;
	
	@Transactional
	public Long Save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
}
