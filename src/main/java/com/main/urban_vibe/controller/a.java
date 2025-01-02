package com.main.urban_vibe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class a {
	@GetMapping("/i") 
	String b(@RequestBody String x) {
		return x;
	}
}
