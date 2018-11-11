package com.codebytes.autobook.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class AutobookUserApplication
{
	@GetMapping("/user")
	public String login () { return "login"; }

	@GetMapping("/user/registration")
	public String register () { return "registration"; }

	@GetMapping("/user/dashboard")
	public String dashboard () { return "dashboard"; }

	@GetMapping("/user/dashboard/cart")
	public String cart () { return "cart"; }

	@GetMapping("/user/dashboard/blog")
	public String blog () { return "blog"; }

	@GetMapping("/user/dashboard/blog_details")
	public String blog_details () { return "blog-details"; }

	@GetMapping("/user/dashboard/confirmation")
	public String confirmation () { return "confirmation"; }

	@GetMapping("/user/dashboard/product_details")
	public String product_details () { return "product-details"; }

	public static void main(String[] args) {
		SpringApplication.run(AutobookUserApplication.class, args);
	}
}
