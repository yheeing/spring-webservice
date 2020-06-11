package com.yheeing.webservice;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yheeing.webservice.domain.posts.Posts;
import com.yheeing.webservice.domain.posts.PostsRepository;
import com.yheeing.webservice.domain.posts.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
	 @Autowired
	    private PostsService postsService;

	    @Autowired
	    private PostsRepository postsRepository;

	    @After
	    public void cleanup () {
	        postsRepository.deleteAll();
	    }

	    @Test
	    public void Dto데이터가_posts테이블에_저장된다 () {
	        //given
	        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
	        		.title("Content Title")
					.content("Contents Bla")
					.author("yheeing@gmail.com")
					.build();

	        //when
	        postsService.Save(dto);

	        //then
	        Posts posts = postsRepository.findAll().get(0);
	        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
	        assertThat(posts.getContent()).isEqualTo(dto.getContent());
	        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	    }
}
