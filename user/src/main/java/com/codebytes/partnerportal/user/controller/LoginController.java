package com.codebytes.partnerportal.user.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String login (Principal principal) { return principal == null ? "login" : "redirect:/"; }
}
