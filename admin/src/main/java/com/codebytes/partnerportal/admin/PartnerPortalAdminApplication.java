package com.codebytes.partnerportal.admin;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class PartnerPortalAdminApplication
{

	@GetMapping("/admin/dashboard")
	public String dashboard () {
		return "dashboard";
	}

	@GetMapping("/admin")
	public String login (Principal principal) { return principal == null ? "login" : "redirect:/admin/dashboard"; }

	public static void main(String[] args) {
		SpringApplication.run(PartnerPortalAdminApplication.class, args);
	}
}
