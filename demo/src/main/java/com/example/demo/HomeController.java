package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/myInfo")
	public String myInfo() {
		System.out.println("asdasdsasdadsd확인용");
		return "member/myInfo";
	}
}
