package com.sist.model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.ProductDAO;
import com.sist.vo.ProductVO;
import com.sist.vo.ProductVO;

public class ProductModel {

	@RequestMapping("product/ProductList.do")
public String productList(HttpServletRequest request, HttpServletResponse response) {
	String strpage=request.getParameter("page");
	String ct=request.getParameter("ct");
	String rt=request.getParameter("rt");
	List<ProductVO>list = new ArrayList<ProductVO>();
	ProductDAO dao=ProductDAO.newInstace();
	if (strpage==null) {
		strpage="1";
	}
	if (ct==null) {
		ct="전체";
	}
	if(rt==null) {
		
		rt="p_hit";
	}

	int curpage=Integer.parseInt(strpage);
	int totalpage=dao.productTotalPage(ct,rt);
	
	final int block=10;
	int start = ((curpage-1)/block*block)+1;
	int end = ((curpage-1)/block*block)+10;
	if(end>totalpage) {
		end=totalpage;
	}
		
		list =dao.productList(ct, curpage,rt);
		
		
		
		
		
		request.setAttribute("product_jsp", "../product/ProductList.jsp");
		request.setAttribute("main_jsp", "../product/ProductMain.jsp");
		request.setAttribute("list", list);
		request.setAttribute("page", strpage);
		request.setAttribute("ct", ct);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("rt", rt);
	
	return "../main/main.jsp";
}
	
	
	@RequestMapping("product/productDetail.do")
	public String productDetail(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strpage=request.getParameter("page");
		String ct=request.getParameter("ct");
		String rt=request.getParameter("rt");
		String pno=request.getParameter("pno");
		String lcount=request.getParameter("count");
		
		
			ProductDAO dao=ProductDAO.newInstace();
			ProductVO vo =dao.productDetail(Integer.parseInt(pno));
			request.setAttribute("vo", vo);
			request.setAttribute("main_jsp", "../product/productDetail.jsp");
			request.setAttribute("page", strpage);
			request.setAttribute("ct", ct);
			request.setAttribute("rt", rt);
			request.setAttribute("lcount",lcount);//목록으로 돌아가는 카운트
			
			List<ProductVO>clist=new ArrayList<ProductVO>();
			try {
			
				Cookie[] cookies=request.getCookies();
							
				if(cookies!=null) {
					int  count =0;
					for(int i=cookies.length-1;i>=0;i--) {
						
						if (cookies[i].getName().startsWith("pno_")) {
							String cvalue=cookies[i].getValue();
							int cpno=Integer.parseInt(cvalue);
							ProductVO cvo =dao.productDetail_Before(cpno);
							clist.add(cvo);
							count ++;
							
							request.setAttribute("clist", clist);
							request.setAttribute("count", clist.size());//쿠키목록출력카운트
							if(count==5) {
								break;
							}
							
						}	
					}
					}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
		
		return "../main/main.jsp";
	}
	
	@RequestMapping("product/DetailBefore.do")
	public String DetailBefore(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String count=request.getParameter("count");
		String pno=request.getParameter("pno");
		String strpage=request.getParameter("page");
		String ct=request.getParameter("ct");
		String rt=request.getParameter("rt");
		try {
			ct=java.net.URLEncoder.encode(ct,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			Cookie cookie=new Cookie("pno_"+pno, pno);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			
				
		
		return "redirect:../product/productDetail.do?pno="+pno+"&rt="+rt+"&page="+strpage+"&ct="+ct+"&count="+count;
	}
	
	
	@RequestMapping("product/DetailListBack.do")
	public String DetailListBack(HttpServletRequest request, HttpServletResponse response) {
		String ct=request.getParameter("ct");
	
		try {
			ct=java.net.URLEncoder.encode(ct,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String strpage=request.getParameter("page");
		String rt=request.getParameter("rt");
		String send="redirect:../product/ProductList.do?page="+strpage+"&ct="+ct+"&rt="+rt;
	String lcount=request.getParameter("lcount");
	

	
	if (lcount.equals("1")) {
		send="redirect:../product/ProductList.do";
	}
		
	
		
		
		return send;
	}
}
