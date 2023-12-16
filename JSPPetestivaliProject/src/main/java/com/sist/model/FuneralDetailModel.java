package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;

public class FuneralDetailModel {
	@RequestMapping("funeralDetail/produce.do")
	public String funeral_main(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../funeralDetail/produce.jsp");
		return "../funeralDetail/produce.jsp";
	}
}
