package com.care.userlog;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.care.log_dao.UserLogDAO;
import com.care.log_dto.UserLogDTO;

public class UserLogServiceImpl implements UserService {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int start = 0;	//디비로 넘겨줄 시작 값
		int viewContent = 2;	//화면에 보여줄 글 갯수
		int webStart = 1;	//웹페이지로 넘겨줄 값(이전 버튼에 사용)
		if(request.getParameter("start")==null) {
			start = 1;	//넘겨온 값이 없다면 무조건 첫페이지 글을 가져온다.
		}else {
			//디비로부터 가져오기 위한 값 계산
			start = (Integer.parseInt(request.getParameter("start")) - 1) * viewContent + 1;
			//웹으로 넘겨줄 값 저장
			webStart = Integer.parseInt(request.getParameter("start"));
		}
		int end = start + viewContent - 1;
		UserLogDAO dao = new UserLogDAO();
		//ArrayList<UserLogDTO> lists = dao.list();
		//dao.list();
		ArrayList<UserLogDTO> lists = dao.list(start, end);
		int totPage = dao.page();
		
		//보여줄 글 2개씩 페이지 수 얻어오기
		int endPage = totPage / viewContent + (totPage % viewContent == 0 ? 0:1);
		if(end > totPage) {
			end = totPage;		//url 직접 접근 제어
		}
		
		if(start > totPage) {
			start = totPage;		//url 직접 접근 제어
		}
		
		ArrayList<Integer> arrTot = new ArrayList<Integer>();
		for(int i = 1; i <= endPage; i++) {
			arrTot.add(i);
		}
		model.addAttribute("start", webStart);	//이전 또는 다음 버튼에 활용
		model.addAttribute("arrTot", arrTot);	//jsp 넘버링
		model.addAttribute("totPage", arrTot.size());
		model.addAttribute("logList", lists);	//글 내용
	}

}
