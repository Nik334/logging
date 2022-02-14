package com.demo.logging.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {

	private List<String> names = Arrays.asList("hello", "my", "world");

	@GetMapping("/name")
	public String getMessage() {
		log.info(names.toString());
		return "name";
	}
}
