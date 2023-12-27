package com.sist.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.UserDAO;
import com.sist.dao.WalkDAO;
import com.sist.dao.*;
import com.sist.vo.ReplyVO;
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
		
		List<ReplyVO>rlist=dao.walkReplyListData(Integer.parseInt(wno));
		int replyAmount=dao.walkReplyAmount(Integer.parseInt(wno));
			
		
		//코스별 기능구현 에이젝스.....
		request.setAttribute("replyAmount", replyAmount);
		request.setAttribute("rlist", rlist);
		request.setAttribute("loc", loc);
		request.setAttribute("curpage", page);
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../walk/walkDetail.jsp");
			
				
		
		return "../main/main.jsp";
	
}
	@RequestMapping("walk/replyInsert.do")
	public String replyInsert(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String wno=request.getParameter("wno");
		String pwd=request.getParameter("password");
		String rcontent=request.getParameter("rcontent");
		String loc=request.getParameter("loc");
		System.out.println(loc);
		
		try {
			loc=URLEncoder.encode(loc,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String page=request.getParameter("page");
		
		WalkDAO dao=WalkDAO.newInstance();
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
	ReplyVO vo =new ReplyVO();
	
		
		
		vo.setBno(Integer.parseInt(wno));
		
		vo.setRcontent(rcontent);
		
		vo.setUserid(id);
		vo.getUserid();
		
		
				dao.walkReplyInsert(vo, pwd);
		
		return "redirect:../walk/walkDetail.do?wno="+wno+"&loc="+loc+"&page="+page;
	
	}
	
	
	
	@RequestMapping("walk/addReply.do")
	public String addRePly(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rno=request.getParameter("rno");
		String wno=request.getParameter("wno");
		String addpwd=request.getParameter("addpassword");
		String addcontent=request.getParameter("addcontent");
		String loc=request.getParameter("loc");
		String page=request.getParameter("page");
		
		WalkDAO dao=WalkDAO.newInstance();
		
		
		
		try {
			loc=URLEncoder.encode(loc,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		ReplyVO vo =new ReplyVO();
		
		
		
		

	
		
		
		vo.setBno(Integer.parseInt(wno));
		vo.setRno(Integer.parseInt(rno));
		vo.setRcontent(addcontent);
		
		vo.setUserid(id);
	
		dao.walkAddReplyInsert(addpwd, vo);
	
		
		return "redirect:../walk/walkDetail.do?wno="+wno+"&loc="+loc+"&page="+page;
	
	}
	
	
	@RequestMapping("walk/replyDelete.do")
	public String replytDelete(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rno=request.getParameter("rno");
		String wno=request.getParameter("wno");
		String dpwd=request.getParameter("dpassword");
		String loc=request.getParameter("loc");
		String page=request.getParameter("page");
		
		WalkDAO dao=WalkDAO.newInstance();
		
		
		
		try {
			loc=URLEncoder.encode(loc,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
			dao.walkDeleteReply(Integer.parseInt(rno), dpwd);
		
	
		return "redirect:../walk/walkDetail.do?wno="+wno+"&loc="+loc+"&page="+page;
	
	}
	
	
	
	@RequestMapping("walk/replyUpdate.do")
	public String replyUpdate(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String rno=request.getParameter("rno");
		String wno=request.getParameter("wno");
		String uppwd=request.getParameter("uppassword");
		String loc=request.getParameter("loc");
		String page=request.getParameter("page");
		String upcontent=request.getParameter("upcontent");
		WalkDAO dao=WalkDAO.newInstance();
		
		
		
		try {
			loc=URLEncoder.encode(loc,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ReplyVO vo=new ReplyVO();
		vo.setRno(Integer.parseInt(rno));
		vo.setRcontent(upcontent);
		
		
		dao.walkReplyUpdate(vo, uppwd);
		
	
		return "redirect:../walk/walkDetail.do?wno="+wno+"&loc="+loc+"&page="+page;
	
	}
}
