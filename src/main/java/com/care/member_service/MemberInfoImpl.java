package com.care.member_service;

import org.springframework.ui.Model;
import com.care.member_dao.MemberDAO;

public class MemberInfoImpl implements MemberService{
	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		model.addAttribute("members",dao.memberInfo());
		return 0;
	}
}
