package com.cy.microservice.consumer.movie.controller;

import com.cy.microservice.consumer.movie.bean.User;
import com.cy.microservice.consumer.movie.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie/")
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("getUser")
	public User getUser() {
		return userFeignClient.getUser();
	}
	

	@GetMapping("postUser")
	public User postUser() {
		User user = new User();
		user.setName("postUser");
		return userFeignClient.postUser(user);
	}
}
