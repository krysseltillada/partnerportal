package com.codebytes.autobook.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class AutobookAdminApplication {

	@GetMapping("/admin")
	public String home () {
		return "index";
	}

	@GetMapping("/forms")
	public String forms () { return "forms"; }

	public static void main(String[] args) {
		SpringApplication.run(AutobookAdminApplication.class, args);
	}
}
