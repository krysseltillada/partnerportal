package com.codebytes.autobook.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class AutobookUserApplication
{
	public static void main(String[] args) {
		SpringApplication.run(AutobookUserApplication.class, args);
	}
}
