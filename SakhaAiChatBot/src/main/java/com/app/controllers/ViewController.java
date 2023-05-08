package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
@Controller
@CrossOrigin(maxAge=3600,origins="*")
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
