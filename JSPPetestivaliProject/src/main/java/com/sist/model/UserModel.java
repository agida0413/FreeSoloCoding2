package com.sist.model;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.UserDAO;
import com.sist.vo.UserVO;

public class UserModel {
	@RequestMapping("user/userJoin.do")
	public String userJoin(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		System.out.println(id);
		String send="";
		UserDAO dao=UserDAO.newInstance();
		boolean joinCheck=false;
		joinCheck=dao.userJoinCheck(id);
		
		if (joinCheck==false) {
			request.setAttribute("msg", "이미 있는 아이디입니다");
			send="../user/join.jsp";
		}
		else {
			UserVO vo =new UserVO();
			vo.setId(id);
			System.out.println(vo.getId());
			vo.setPwd(pwd);
			vo.setName(name);
			dao.userJoin(vo);
		HttpSession session=request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("name", name);
			send="../user/joinWelcome.jsp";
		}
		
		
		
		

		
			
				
		
		return send;
	
}
	@RequestMapping("user/userLogin.do")
	public String userLogin(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			String id=request.getParameter("id");
			String pwd=request.getParameter("pwd");
			
			String send="";	
			
			UserDAO dao=UserDAO.newInstance();
			
			HttpSession session =request.getSession();
			
			//아이디 가 없는경우 =  >no
			//아이디가 있고 패스워드가 틀린경우 = >no
			//아이디가있고 패스워드가 맞는 경우 = >yes 
			//리턴값으로 vo vo.msg = > no => boolean
		UserVO vo = dao.userLogin(id, pwd);
		
		if (vo.getMsg().equals("YES")) {
			
			session.setAttribute("id", id);
			session.setAttribute("name", vo.getName());
			session.setAttribute("admin", vo.getAdmin());
			
			send="/main/main.do";
		}
		else if (vo.getMsg().equals("NOPWD")) {
			
		String msg="비밀번호가 틀립니다.";
			request.setAttribute("Loginmsg", msg);
			
		
			send="../user/login.jsp";
		}
		else if (vo.getMsg().equals("NOID")) {
		String msg="아이디가 존재하지않습니다.";
		
			request.setAttribute("Loginmsg", msg);
			
			send="../user/login.jsp";
		}
		
		
		
		

		
			
				
		
		return send;
	
}
	
	
	@RequestMapping("user/userLogout.do")
	public String userLogout(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session =request.getSession();
			String LogoutMsg="이용해주셔서 감사합니다.";
			
			session.invalidate();
			request.setAttribute("LogoutMsg", LogoutMsg);
		
		

		
			
				
		
		return "/main/main.do";
	
}
	
	
	
	
	
}
