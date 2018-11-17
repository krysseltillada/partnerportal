package com.codebytes.partnerportal.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EntityScan(basePackages="com.codebytes.partnerportal.common")
@Controller
public class PartnerPortalUserApplication
{

	

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
