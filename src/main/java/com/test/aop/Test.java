package com.test.aop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class Test {
	private SimpleDateFormat dayTime;
	private long startTimeLong;
	private long endTimeLong;
	private String startTimeString;
	private String endTimeString;
	private long resultTime;
	
	@Around("execution(* com.care.controller.MemberController.*(..))")
	public Object setMapParameter(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Controller 실행 시에 출력된다.");
		return joinPoint.proceed();
	}
	
	@Before("execution(* com.care.controller.MemberController.successLogin(..))")
	public void beforeExecute() {
		dayTime = new SimpleDateFormat("yyyy-MM-dd aa hh:mm:ss");
		startTimeLong = System.currentTimeMillis();
		startTimeString = dayTime.format(startTimeLong);
		System.out.println("시작 시간 : " + startTimeString);
	}
	
	@Before("execution(* com.care.controller.MemberController.logout(..))")
	public void afterExecute() {
		endTimeLong = System.currentTimeMillis();
		endTimeString = dayTime.format(endTimeLong);
		resultTime = (endTimeLong - startTimeLong) / 1000;
		System.out.println("종료 시간 : " + endTimeString);
		System.out.println("사용 시간 : " + resultTime);
		logoutTime();
	}
	
	public void logoutTime() {
		ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		System.out.println("session : " + session.getAttribute("userId"));
		String sql = "insert into userlog values(time_number.nextval, ?, ?, ?, ?)";
		System.out.println("마지막 디비 저장");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(url, "jsp", "1234");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  (String)session.getAttribute("userId"));
			ps.setString(2,  startTimeString);
			ps.setString(3,  endTimeString);
			ps.setLong(4,  resultTime);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

