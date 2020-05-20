package com.care.log_dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.care.log_dto.UserLogDTO;
import com.care.template.Constant;

public class UserLogDAO {
	public ArrayList<UserLogDTO> list(){
		
		String sql = "select * from userlog";
		ArrayList<UserLogDTO> lists = null;
		lists = (ArrayList<UserLogDTO>)Constant.template.query(sql,  new BeanPropertyRowMapper<UserLogDTO>(UserLogDTO.class));
		return lists;
	}
	
	public ArrayList<UserLogDTO> list(int s, int e){
		String sql = "select * from (select rownum rn, A.* from " + 
		" (select * from userlog order by num desc)A) where rn between " + s + " and " + e;
		ArrayList<UserLogDTO> lists = null;
		lists = (ArrayList<UserLogDTO>)Constant.template.query(sql, new BeanPropertyRowMapper<UserLogDTO>(UserLogDTO.class));
		return lists;
	}
	
	public int page() {
		String sql = "select count(*) from userlog";
		int resultPage = 0;
		resultPage = Constant.template.queryForInt(sql);
		return resultPage;
	}
}
