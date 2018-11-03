package com.codebytes.autobook.autobook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class AutobookApplication {

	@GetMapping("/")
	public String home () {
		return "home";
	}

	public static void main(String[] args) {
		SpringApplication.run(AutobookApplication.class, args);
	}
}
