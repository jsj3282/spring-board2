package com.care.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.care.member_service.MUserCheckImpl;
import com.care.member_service.*;
import com.care.template.Constant;

@Controller
public class MemberController {
	private MemberService ms;
	public MemberController() {
		System.out.println("BoardController 실행");
		String configLocation = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext(configLocation);
		JdbcTemplate template = ctx.getBean("template",JdbcTemplate.class);
		Constant.template = template;
	}

	@RequestMapping("/index")
	public String index() {
		System.out.println("index 실행");
		return "member/index";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		System.out.println("login 실행");
		return "member/login";
	}
	@RequestMapping(value="/user_check", method=RequestMethod.POST)
	public String user_check(HttpServletRequest request,Model model) {
		System.out.println("user_check 실행");
		model.addAttribute("request",request);
		ms = new MUserCheckImpl();
		int result = ms.execute(model);
		if(result == 0) {
			//return "member/successLogin";
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	@RequestMapping("successLogin")
	public String successLogin() {
		return "member/successLogin";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		System.out.println("logout 실행");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") != null) {
			session.invalidate();
		}
		return "redirect:index";
	}
	@RequestMapping("/memberInfo")
	public String memberInfo(Model model) {
		System.out.println("memberInfo 실행");
		ms = new MemberInfoImpl();
		ms.execute(model);
		return "member/memberInfo";
	}
	@RequestMapping("/info")
	public String info(HttpServletRequest request,Model model) {
		System.out.println("info 실행");
		model.addAttribute("request",request);
		ms = new MemberDataImpl();
		ms.execute(model);
		return "member/info";
	}
	@RequestMapping("/register_form")
	public String register_form() {
		System.out.println("register_form 실행");
		return "member/register";
	}
	@RequestMapping("/register")
	public String register(HttpServletRequest request, Model model) {
		System.out.println("register 실행");
		model.addAttribute("request",request);
		ms = new MemberRegisterImpl();
		int result = ms.execute(model);
		if(result == 1)   return "redirect:login";
		else   return "member/register";
	}

}
