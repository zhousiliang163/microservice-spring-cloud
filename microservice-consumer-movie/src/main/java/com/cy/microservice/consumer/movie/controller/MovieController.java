package com.cy.microservice.consumer.movie.controller;

import com.cy.microservice.consumer.movie.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie/")
public class MovieController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("getUser")
	public User getUser() {
		return restTemplate.getForObject("http://localhost:8861/user/getUser", User.class);
	}
}
