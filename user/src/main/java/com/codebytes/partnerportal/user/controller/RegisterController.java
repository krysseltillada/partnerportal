package com.codebytes.partnerportal.user.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
	@GetMapping("/register")
	public String register ( Principal principal) { return principal == null ? "registration" : "redirect:/"; }
}
