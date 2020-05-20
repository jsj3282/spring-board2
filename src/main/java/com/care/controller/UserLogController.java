package com.care.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.userlog.UserLogServiceImpl;
import com.care.userlog.UserService;

@Controller
public class UserLogController {
	private UserService us;
	
	//2번 문제
	@RequestMapping("/userlog")
	public String userlog(Model model) {
		System.out.println("userlog 실행");
		us = new UserLogServiceImpl();
		us.execute(model);
		return "userlog/userlog";
	}
	
	//3번문제 + paging
	@RequestMapping("/userlog")
	public String userlog(Model model, HttpServletRequest request) {
		System.out.println("userlog 실행");
		model.addAttribute("request", request);
		us = new UserLogServiceImpl();
		us.execute(model);
		return "userlog/userlog";
	}
	
}
