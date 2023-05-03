package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Democontroller {
	
	@GetMapping("/")
	public String allusers() {
		
		return "Hello Everyone";
	}
	@GetMapping("/admin")
	public String admin() {
		
		return "Hello admin";
	}
	@GetMapping("/user")
	public String user() {
		
		return "Hello user";
	}

	

}
