package com.cy.spring.cloud.microservice.provider.user.controller;

import com.cy.spring.cloud.microservice.provider.user.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("getUser")
	public User getUser() {
		User user = new User();
		user.setName("xiaozhou");
		user.setAge(11);
		user.setAddress("hangzhou");
		logger.info("----------------" + user);
		return user;
	}
	
}
