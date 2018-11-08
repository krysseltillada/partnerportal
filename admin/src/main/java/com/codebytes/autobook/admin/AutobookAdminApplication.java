package com.codebytes.autobook.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class AutobookAdminApplication {

	@GetMapping("/admin/dashboard")
	public String dashboard () {
		return "dashboard";
	}

	@GetMapping("/admin")
	public String login () { return "login"; }

	public static void main(String[] args) {
		SpringApplication.run(AutobookAdminApplication.class, args);
	}
}
