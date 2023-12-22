package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;

public class MypageModel {
@RequestMapping("mypage/mypagemain.do")
public String mypageMain(HttpServletRequest request, HttpServletResponse response)
{
	
	request.setAttribute("main_jsp", "../mypage/mypagemain.jsp");
	return "../main/main.jsp";
}
@RequestMapping("mypage/petreg.do")
public String petregData(HttpServletRequest request, HttpServletResponse response)
{
	String msg="홍길동";
	request.setAttribute("msg", msg);
	request.setAttribute("main_jsp", "../mypage/petreg.jsp");
	return "../main/main.jsp";
}
@RequestMapping("mypage/res.do")
public String resList(HttpServletRequest request, HttpServletResponse response)
{
	String msg="홍길동";
	request.setAttribute("msg", msg);
	request.setAttribute("mypage_jsp", "../mypage/res.jsp");
	request.setAttribute("main_jsp", "../mypage/mypagemain.jsp");
	
	return "../main/main.jsp";
}


}
