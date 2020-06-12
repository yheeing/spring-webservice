package com.yheeing.webservice.web;

<<<<<<< HEAD
import com.yheeing.webservice.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
=======
import org.springframework.stereotype.Controller;
>>>>>>> ef9ac3d... test 3
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

<<<<<<< HEAD
	PostsService postsService;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", postsService.findAllDesc());
=======
	@GetMapping("/")
	public String main() {
>>>>>>> ef9ac3d... test 3
		return "main";
	}
}
