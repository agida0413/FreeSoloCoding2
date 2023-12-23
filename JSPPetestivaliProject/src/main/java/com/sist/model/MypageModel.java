package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;

public class MypageModel {
@RequestMapping("mypage/mypage_main.do")
public String mypageMain(HttpServletRequest request, HttpServletResponse response)
{
	
	request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
	return "../main/main.jsp";
}
@RequestMapping("mypage/mypetreg.do")
public String petregData(HttpServletRequest request, HttpServletResponse response)
{
	String msg="홍길동";
	request.setAttribute("msg", msg);
	request.setAttribute("main_jsp", "../mypage/mypetreg.jsp");
	return "../main/main.jsp";
}
@RequestMapping("mypage/myres.do")
public String resList(HttpServletRequest request, HttpServletResponse response)
{
	String msg="홍길동";
	request.setAttribute("msg", msg);
	request.setAttribute("mypage_jsp", "../mypage/myres.jsp");
	request.setAttribute("main_jsp", "../mypage/mypagemain.jsp");
	
	return "../main/main.jsp";
}


}
