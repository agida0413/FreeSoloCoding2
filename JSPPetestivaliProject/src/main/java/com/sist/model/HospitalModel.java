package com.sist.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.HospitalDAO;
import com.sist.vo.*;

public class HospitalModel {
@RequestMapping("hspt/find.do")
	public String hsptTotalList(HttpServletRequest request,HttpServletResponse response)
	{
	try {
		request.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	String page=request.getParameter("page");
	if(page==null)
		page="1";
	String fd=request.getParameter("fd");
	String st=request.getParameter("st"); // 파라미터값을 받음
	 
	HospitalDAO dao=new HospitalDAO(); 
	List<HospitalVO> list=new ArrayList<HospitalVO>();
	int totalpage=0;
	int curpage=Integer.parseInt(page); 
	List<HospitalVO> statelist=dao.HsptStateData();
	
	if(st==null && fd==null) // 검색하지 않았을 때
	{	
		st="전체";
		totalpage=dao.hsptTotalPage();
		list = dao.hsptTotalList(totalpage);
	}

	final int BLOCK=10;
	int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	
	if(endPage>totalpage)
	{
		endPage=totalpage;
	}

	request.setAttribute("curpage", curpage);
	request.setAttribute("totalpage", totalpage);
	request.setAttribute("startPage", startPage);
	request.setAttribute("endPage", endPage);
	request.setAttribute("list", list);
	request.setAttribute("statelist", statelist);
	request.setAttribute("hspt_jsp", "../hspt/find.jsp");
	request.setAttribute("main_jsp", "../hspt/hsptmain.jsp");

		return "../main/main.jsp";
	}

@RequestMapping("hspt/hsptsearch.do")
public String hsptSearchDetail(HttpServletRequest request,HttpServletResponse response)
{
try {
	request.setCharacterEncoding("UTF-8");
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


String page=request.getParameter("page");
if(page==null)
	page="1";
int curpage=Integer.parseInt(page); 
String fd=request.getParameter("fd");
String st=request.getParameter("st"); // 파라미터값을 받음

HospitalDAO dao=new HospitalDAO(); 
List<HospitalVO> list=new ArrayList<HospitalVO>();
int totalpage=dao.hsptSearchTotalPage(fd, st);
list=dao.hsptSearchList(curpage, fd, st);

if(st==null) // 검색하지 않았을 때
{	
	st="전체";
	totalpage=dao.hsptTotalPage();
	list=dao.hsptTotalList(totalpage);
}

	

List<HospitalVO> statelist=dao.HsptStateData();


final int BLOCK=10;
int startPage=((curpage-1)/BLOCK*BLOCK)+1;
int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;

if(endPage>totalpage)
{
	endPage=totalpage;
}


request.setAttribute("fd", fd);
request.setAttribute("st", st);
request.setAttribute("curpage", curpage);
request.setAttribute("totalpage", totalpage);
request.setAttribute("startPage", startPage);
request.setAttribute("endPage", endPage);
request.setAttribute("list", list);
request.setAttribute("statelist", statelist);
request.setAttribute("hspt_jsp", "../hspt/hsptsearch.jsp");
request.setAttribute("main_jsp", "../hspt/hsptmain.jsp");

	return "../main/main.jsp";
}

@RequestMapping("hspt/detail.do")
public String hsptDetailList(HttpServletRequest request,HttpServletResponse response)
{
	String no=request.getParameter("no");
	HospitalDAO dao=HospitalDAO.newInstance();
	HospitalVO vo=dao.hsptDetailList(Integer.parseInt(no));
	
	request.setAttribute("no", no);
	request.setAttribute("vo", vo);
	
	request.setAttribute("main_jsp", "../hspt/detail.jsp");
	return "../main/main.jsp";
}

@RequestMapping("hspt/newsmain.do")
public String hsptNewsMain(HttpServletRequest request, HttpServletResponse response)
{
	String page=request.getParameter("page");
	if(page==null)
		page="1";
	int curpage=Integer.parseInt(page);
	
	HospitalDAO dao=new HospitalDAO();
	List<HospitalVO> list3=dao.hsptNewsList(curpage);
	
	request.setAttribute("curpage", curpage);
	request.setAttribute("list3", list3);
	request.setAttribute("main_jsp", "../hspt/newsmain.jsp");
	return "../main/main.jsp";
}

}
