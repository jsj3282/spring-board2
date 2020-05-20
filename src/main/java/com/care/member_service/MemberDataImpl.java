package com.care.member_service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.member_dao.MemberDAO;

public class MemberDataImpl implements MemberService{
    @Override
    public int execute(Model model) {
        Map<String, Object> map = model.asMap();
        HttpServletRequest request = (HttpServletRequest)map.get("request");
        String id = request.getParameter("id");
        MemberDAO dao = new MemberDAO();
        model.addAttribute("memberData",dao.memberData(id));
        return 0;
    }
}
