package com.yheeing.webservice;

import com.yheeing.webservice.domain.posts.Posts;
import com.yheeing.webservice.domain.posts.PostsMainResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yheeing.webservice.domain.posts.PostsRepository;
import com.yheeing.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;
	
	@Transactional
	public Long Save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}

	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
		return postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}
}
