package com.codebytes.partnerportal.user;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class PartnerPortalUserApplication
{
	@GetMapping("/")
	public String home () { return "index"; }
	
	@GetMapping("/login")
	public String login (Principal principal) { return principal == null ? "login" : "redirect:/"; }

	@GetMapping("/register")
	public String register ( Principal principal) { return principal == null ? "registration" : "redirect:/"; }

	@GetMapping("/cart")
	public String cart () { return "cart"; }

	@GetMapping("/blog")
	public String blog () { return "blog"; }

	@GetMapping("/blog_details")
	public String blogDetails () { return "blog-details"; }

	@GetMapping("/confirmation")
	public String confirmation () { return "confirmation"; }

	@GetMapping("/product_details")
	public String productDetails () { return "product-details"; }
	
	@GetMapping("/dashboard")
	public String dashboard () { return "dashboard"; }

	public static void main(String[] args) {
		SpringApplication.run(PartnerPortalUserApplication.class, args);
	}
}
