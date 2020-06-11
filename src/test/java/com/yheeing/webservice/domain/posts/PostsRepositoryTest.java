package com.yheeing.webservice.domain.posts;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		
		postsRepository.deleteAll();
	}
	
	@Test
	public void LoadContents() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
				.title("Content Title")
				.content("Contents Bla")
				.author("yheeing@gmail.com")
				.build());
		
		//when
		List<Posts> postList = postsRepository.findAll();
		
		//then
		Posts post = postList.get(0);
		assertTrue(post.getCreatedDate().isAfter(now));
        assertTrue(post.getModifiedDate().isAfter(now));
        
//		assertThat(post.getTitle(), is("Content Title"));
//		assertThat(post.getContent(), is("Contents Bla"));
	}
}
