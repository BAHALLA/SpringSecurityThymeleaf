package com.sid.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

	@GetMapping("/manager")
	public String manager() {
		return "manager";
	}
}
