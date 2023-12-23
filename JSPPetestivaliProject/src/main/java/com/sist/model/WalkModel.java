package com.sist.model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.UserDAO;
import com.sist.dao.WalkDAO;
import com.sist.vo.UserVO;
import com.sist.vo.WalkVO;

public class WalkModel {
	@RequestMapping("walk/walkList.do")
	public String walkList(HttpServletRequest request, HttpServletResponse response) {
		String strpage= request.getParameter("page");
		String loc=request.getParameter("loc");
		WalkDAO dao=WalkDAO.newInstance();
		List<WalkVO>list=null;
		if (strpage==null) {
			strpage="1";
		}
		if (loc==null) {
			loc="전체";
		}
		
		int curpage=Integer.parseInt(strpage);
		int totalpage=dao.walkTotalPage(loc);
		System.out.println(totalpage);
		final int block=10;
		int start = ((curpage-1)/block*block)+1;
		int end = ((curpage-1)/block*block)+10;
		if(end>totalpage) {
			end=totalpage;
		}
		
		list=dao.walkList(loc, curpage);
		request.setAttribute("list", list);
		request.setAttribute("curpage", strpage);
		request.setAttribute("loc", loc);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("walk_jsp", "../walk/walkList.jsp");
		request.setAttribute("main_jsp", "../walk/walkMain.jsp");
		request.setAttribute("totalpage", totalpage);
	
				
		
		return "../main/main.jsp";
	
}
	
	
	@RequestMapping("walk/walkDetail.do")
	public String walkDetail(HttpServletRequest request, HttpServletResponse response) {
		String wno=request.getParameter("wno");
		String page=request.getParameter("page");
		String loc=request.getParameter("loc");
		WalkDAO dao=WalkDAO.newInstance();
		
		WalkVO vo=dao.walkDetail(Integer.parseInt(wno));
		
		
			
		
		//코스별 기능구현 에이젝스.....
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../walk/walkDetail.jsp");
			
				
		
		return "../main/main.jsp";
	
}
}
