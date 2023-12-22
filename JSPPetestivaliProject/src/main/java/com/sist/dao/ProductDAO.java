package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.ProductVO;

public class ProductDAO {
private PreparedStatement ps;
private Connection conn;
private  static ProductDAO dao;
private CreateDBCPconnection dbconn = new CreateDBCPconnection();
private final int ROW_SIZE=12;


public static ProductDAO newInstace() {
	if(dao==null) {
		dao=new ProductDAO();
	}
	return dao;
	
}


public List<ProductVO> homeProduct(){
	List<ProductVO>list=new ArrayList<>();
	try {
		conn=dbconn.getConnection();
		String sql="SELECT p_image,p_name,num "
					+"FROM (SELECT p_image,p_name,rownum as num "
					+"FROM (SELECT p_image,p_name FROM product_detail ORDER BY p_hit DESC)) "
					+"WHERE num BETWEEN 1 AND 5";
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			ProductVO vo=new ProductVO();
		String p_image=rs.getString(1);
		String p_name=rs.getString(2);
	
		
		vo.setP_image(p_image);
		vo.setP_name(p_name);
		list.add(vo);
		
		
		}
		rs.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return list;
}



public List<ProductVO> productBystackList(String ct,int page){
	
	List< ProductVO> list= new ArrayList<ProductVO>();
	String msg="";
	
	if(!(ct.equals("전체"))){
		ct="'"+ct+"'";
		msg="AND p_category="+ct;
	}
	
	
	
	try {
		
		conn= dbconn.getConnection();
		String sql="SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack num "
					+"FROM (SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack,rownum as num "
					+"FROM (SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack FROM product_detail "
					+ "WHERE P_STACK <3 AND P_STACK>0 "+msg+" ORDER BY p_stack ASC"
					+")) " +"WHERE num BETWEEN ? and ?";
		ps=conn.prepareStatement(sql);
		
		int start=(ROW_SIZE*page)-(ROW_SIZE-1);
		int end= ROW_SIZE*page;
		
		ps.setInt(1, start);
		ps.setInt(2, end);
		
		
	
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			ProductVO vo= new ProductVO();
			vo.setPno(rs.getInt(1));
			vo.setP_name(rs.getString(2));
			vo.setP_image(rs.getString(3));
			vo.setP_percent(rs.getString(4));
			vo.setP_lower_price(rs.getString(5));
			vo.setP_category(rs.getString(6));
			vo.setP_stack(rs.getInt(7));
			list.add(vo);
			
		}
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return list;
}


public List<ProductVO> productByASCList(String ct,int page,String rt){
	
	List< ProductVO> list= new ArrayList<ProductVO>();
	String msg="";
	
	
	
	if(!(ct.equals("전체"))){
		ct="'"+ct+"'";
		msg= "WHERE p_category = "+ct; 
	}
	
	
	
	try {
		int start=(ROW_SIZE*page)-(ROW_SIZE-1);
		int end= ROW_SIZE*page;
		System.out.println(start);
		System.out.println(end);
		conn= dbconn.getConnection();
		String sql="SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack num "
					+"FROM (SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack,rownum as num "
					+"FROM (SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack FROM product_detail "
					+ msg+" ORDER BY "+rt+" ASC "
					+")) " +"WHERE num BETWEEN ? and ? ";
		ps=conn.prepareStatement(sql);
		
		
		
		ps.setInt(1, start);
		ps.setInt(2, end);
		
		
	
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			ProductVO vo= new ProductVO();
			vo.setPno(rs.getInt(1));
			vo.setP_name(rs.getString(2));
			vo.setP_image(rs.getString(3));
			vo.setP_percent(rs.getString(4));
			vo.setP_lower_price(rs.getString(5));
			vo.setP_category(rs.getString(6));
			vo.setP_stack(rs.getInt(7));
			list.add(vo);
			
		}
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return list;
}





public List<ProductVO> productByDescList(String ct,int page,String rt){
	System.out.println("호출");
	List< ProductVO> list= new ArrayList<ProductVO>();
	String msg="";
	
	
	
	if(!(ct.equals("전체"))){
		ct="'"+ct+"'";
		msg= "WHERE p_category = "+ct; 
	}
	
	
	
	try {
		
		conn= dbconn.getConnection();
		String sql="SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack num "
					+"FROM (SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack,rownum as num "
					+"FROM (SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack FROM product_detail "
					+ msg+" ORDER BY "+rt+ " DESC "
					+")) " +"WHERE num BETWEEN ? and ?";
		ps=conn.prepareStatement(sql);
		System.out.println(sql);
		
		int start=(ROW_SIZE*page)-(ROW_SIZE-1);
		int end= ROW_SIZE*page;
		
		ps.setInt(1, start);
		ps.setInt(2, end);
		
		
	
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			ProductVO vo= new ProductVO();
			vo.setPno(rs.getInt(1));
			vo.setP_name(rs.getString(2));
			vo.setP_image(rs.getString(3));
			vo.setP_percent(rs.getString(4));
			vo.setP_lower_price(rs.getString(5));
			vo.setP_category(rs.getString(6));
			vo.setP_stack(rs.getInt(7));
			list.add(vo);
			
		}
		rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return list;
}




public int productByStackTotalPage(String ct) {
	String msg="";
	
	if(!(ct.equals("전체"))){
		ct="'"+ct+"'";
		msg="AND p_category="+ct;
	}
	
	
	int total=0;
	
	try {
		conn=dbconn.getConnection();
		String sql= "Select CEIL(COUNT(*)/"+ROW_SIZE+") FROM product_detail WHERE P_STACK <3 AND P_STACK>0 "+msg; 
		ps=conn.prepareStatement(sql);
		
		ResultSet rs= ps.executeQuery();
		rs.next();
		total = rs.getInt(1);
		System.out.println("테스트"+total);
		rs.close();
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return total;
	
}



public int productTotalPage(String ct) {
	String msg="";
	if(!(ct.equals("전체"))){
		ct="'"+ct+"'";
		msg="WHERE p_category ="+ct;
	}
	
	
	
	
	
	int total=0;
	try {
		conn=dbconn.getConnection();
		String sql= "Select CEIL(COUNT(*)/"+ROW_SIZE+") FROM product_detail "+msg;
		ps=conn.prepareStatement(sql);
		
		ResultSet rs= ps.executeQuery();
		rs.next();
		total = rs.getInt(1);
	
		rs.close();
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return total;
	
}




public ProductVO productDetail(int pno) {
	ProductVO vo=new ProductVO();
	try {
		conn=dbconn.getConnection();
		String sql="UPDATE product_detail SET "
					+"p_hit=p_hit+1 "
					+"WHERE pno="+pno;
		ps=conn.prepareStatement(sql);
		ps.executeUpdate();
		
		sql="SELECT pno,p_name,p_lower_price,p_percent,p_category,p_hit,p_image,p_intprice,p_price,p_detail_text,p_expire_date,p_shipment,p_stack,p_like,p_detail_image from product_detail where pno="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setPno(rs.getInt(1));
			vo.setP_name(rs.getString(2));
			vo.setP_lower_price(rs.getString(3));
			vo.setP_percent(rs.getString(4));
			vo.setP_category(rs.getString(5));
			vo.setP_hit(rs.getInt(6));
			vo.setP_image(rs.getString(7));
 
			vo.setP_intprice(rs.getInt(8));
			vo.setP_price(rs.getString(9));
			vo.setP_detail_text(rs.getString(10));
			vo.setP_expire_date(rs.getString(11));
			vo.setP_shipment(rs.getString(12));
			vo.setP_stack(rs.getInt(13));
			vo.setP_like(rs.getInt(14));
			vo.setP_detail_image(rs.getString(15));
			rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	
	return vo;
	
}



public ProductVO productDetail_Before(int pno) {
	ProductVO vo=new ProductVO();
	try {
		conn=dbconn.getConnection();
		
		
		String sql="SELECT pno,p_name,p_lower_price,p_image from product_detail where pno="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setPno(rs.getInt(1));
			vo.setP_name(rs.getString(2));
			vo.setP_lower_price(rs.getString(3));
			vo.setP_image(rs.getString(4));
			rs.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	
	return vo;
	
}

public List<ProductVO> productSearchList(String sct,String ss,int page){
	String msg="";
	if (sct.equals("전체")) {
		msg="WHERE p_name Like '%'||?||'%'";
	}
	else {
		msg="WHERE p_category=? AND p_name LIKE '%'||?||'%'";
	}
	List<ProductVO>list= new ArrayList<ProductVO>();
	try {
		conn=dbconn.getConnection();
		String sql="SELECT pno,p_name,p_image,p_lower_price,num "
				   +"FROM (SELECT pno,p_name,p_image,p_lower_price,rownum as num "
				   +"FROM (SELECT pno,p_name,p_image,p_lower_price "
				   +"FROM PRODUCT_DETAIL "
				   +msg +")) "
				   +"WHERE num BETWEEN ? AND ?";
		ps=conn.prepareStatement(sql);
		
		int start=(ROW_SIZE*page)-(ROW_SIZE-1);
		int end= ROW_SIZE*page;
		
		if (sct.equals("전체")) {
			ps.setString(1,ss);
			ps.setInt(2, start);
			ps.setInt(3, end);
		}
		else {
			ps.setString(1, sct);
			ps.setString(2, ss);
			ps.setInt(3, start);
			ps.setInt(4, end);
		}
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			ProductVO vo =new ProductVO();
			vo.setPno(rs.getInt(1));
			vo.setP_name(rs.getString(2));
			vo.setP_image(rs.getString(3));
			vo.setP_lower_price(rs.getString(4));
			list.add(vo);
		}
		rs.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	return list;
	
}

public int productSearchTotalPage(String sct,String ss) {
	int total=0;
	String msg="";
	if (sct.equals("전체")) {
		msg="WHERE p_name LIKE '%'||?||'%'";
	}
	else {
		msg="WHERE p_category=? AND p_name LIKE '%'||?||'%'";
	}
	
	
	try {
		conn=dbconn.getConnection();
		String sql="SELECT CEIL(COUNT(*)/"+ROW_SIZE+") FROM PRODUCT_DETAIL "+msg;
		ps=conn.prepareStatement(sql);
		if (sct.equals("전체")) {
			ps.setString(1, ss);
		}
		else {
			ps.setString(1, sct);
			ps.setString(2, ss);
		}
		
		ResultSet rs=ps.executeQuery();
		rs.next();
		total=rs.getInt(1);
		rs.close();
					
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return total;
	
}

public List<Integer> ProductCateNum(){
	List<Integer>list= new ArrayList<Integer>();
	try {
		conn=dbconn.getConnection();
		
		String sql="SELECT COUNT(*) FROM PRODUCT_DETAIL ";
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		rs.next();
		list.add(rs.getInt(1));
		rs.close();
		
		 sql="SELECT COUNT(*) FROM PRODUCT_DETAIL GROUP BY P_CATEGORY";
		ps=conn.prepareStatement(sql);
		 rs=ps.executeQuery();
		while(rs.next()) {
			list.add(rs.getInt(1));
			
		}
		rs.close();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		dbconn.disConnection(conn, ps);
	}
	
	return list;
}


}
