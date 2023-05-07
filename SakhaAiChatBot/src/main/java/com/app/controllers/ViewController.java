package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/dashboard")
	public String dashboard()
	{
		return "dashboard";
	}
	@RequestMapping("/login")
	public String loginpage()
	{
		return "login";
	}
	@RequestMapping("/index")
	public String homepage()
	{
		return "index";
	}
}
