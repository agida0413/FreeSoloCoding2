package com.sist.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.HospitalDAO;
import com.sist.vo.*;

public class HospitalModel {
@RequestMapping("hspt/find.do")
	public String hsptFindDetail(HttpServletRequest request,HttpServletResponse response)
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
	if(fd==null)
		fd="";
	String st=request.getParameter("st");
	if(st==null)
		st="전체";


	HospitalDAO dao=HospitalDAO.newInstance();
	List<HospitalVO> list=dao.HsptFindList(curpage,fd,st);
	int totalpage=dao.totalPage(Integer.parseInt(page),fd,st);
	List<HospitalVO> list2=dao.HsptSearchData();

	
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
	request.setAttribute("list2", list2);
//	request.setAttribute("hspt_jsp", "../hspt/hsptsearchList.jsp");
	request.setAttribute("main_jsp", "../hspt/find.jsp");

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
