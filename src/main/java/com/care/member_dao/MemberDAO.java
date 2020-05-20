package com.care.member_dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.care.member_dto.MemberDTO;
import com.care.template.Constant;

public class MemberDAO {
	private final int CHK_OK=0;
	private final int CHK_NO=1;
	private JdbcTemplate template;
	public MemberDAO() {
		this.template = Constant.template;
	}
	public int userCheck(String id, String pw) {
		String sql="select * from member02 where id = '"+id.trim()+"'";
		MemberDTO dto = null;
		try {
			dto = template.queryForObject(
				sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			if(dto != null) {
				if(pw.equals(dto.getPw()))
					return CHK_OK;
			}
		}catch(Exception e) {  }
		return CHK_NO;
	}
	public ArrayList<MemberDTO> memberInfo(){
		String sql = "select * from member02";
		ArrayList<MemberDTO> members=null;
		members = (ArrayList<MemberDTO>)template.query(
				sql,new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		return members;
	}
	public MemberDTO memberData(String id) {
		String sql="select * from member02 where id = '"+id.trim()+"'";
		MemberDTO dto = null;
		dto = template.queryForObject(
				sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
		return dto;
	}
	public int register(final String id,final String pw) {
	    String sql = "insert into member02 values(?,?)";
	    int result=0;
	    try {
	        result = template.update(sql,new PreparedStatementSetter() {
		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, id);
			ps.setString(2, pw);
		}
	        });
	    }catch(Exception e) { return 0; }
	    return result;
	}

}
