package com.hexaware.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestClassController {
	//nuevo comentario 10
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String viewHome() {
		return "index";
	}
}