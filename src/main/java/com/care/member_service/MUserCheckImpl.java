package com.care.member_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.care.member_dao.MemberDAO;

public class MUserCheckImpl implements MemberService{
	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		int result = dao.userCheck(id,pw);
		if(result == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", request.getParameter("id"));
		}
		return result;
	}
}

