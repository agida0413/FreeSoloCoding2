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



public List<ProductVO> productList(String ct,int page,String rt){
	String db_rt="'"+rt+"'";
	List< ProductVO> list= new ArrayList<ProductVO>();
	String msg="";
	if(ct.equals("전체")){
		
		if (rt.equals("p_stack")) {
			msg="WHERE P_STACK <3 AND P_STACK>0 ORDER BY "+rt+" ASC";
		}
		else if (rt.equals("p_intprice")) {
			msg=" ORDER BY "+rt+" ASC ";	
		}
		else {
			msg=" ORDER BY "+rt+" DESC ";	
		}
	}
	
	else {
		if (rt.equals("p_stack")) {
			msg="WHERE P_STACK <3 AND P_STACK>0 AND p_category = ? ORDER BY "+rt+" ASC";
		}
		else if (rt.equals("p_intprice")) {
			msg= "WHERE p_category = ? ORDER BY " +rt+ " ASC ";	
		}
		else {
			msg= "WHERE p_category = ? ORDER BY " +rt+ " DESC ";	
		}
		 
	}
	
	try {
		int start=(ROW_SIZE*page)-(ROW_SIZE-1);
		int end= ROW_SIZE*page;
		conn= dbconn.getConnection();
		String sql="SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack num "
					+"FROM (SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack,rownum as num "
					+"FROM (SELECT pno,p_name,p_image,p_percent,p_lower_price,p_category,p_stack FROM product_detail "+msg
					+")) " +"WHERE num BETWEEN ? and ?";
		ps=conn.prepareStatement(sql);
		if(!(ct.equals("전체"))) {
			ps.setString(1, ct); 
			
			ps.setInt(2, start);
			ps.setInt(3, end);
		}
		else {
			
			ps.setInt(1, start);
			ps.setInt(2, end);
		}
		
		
		
	
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


public int productTotalPage(String ct,String rt) {
	String msg="";
	if(ct.equals("전체")){
		
		if (rt.equals("p_stack")) {
			msg="FROM product_detail WHERE p_stack<3 AND p_stack>0";
		}
		else {
			msg=" FROM product_detail ";
		}
	}
	else {
		
		if (rt.equals("p_stack")) {
			msg="FROM product_detail WHERE p_stack<3 AND p_stack>0 AND p_category=?";
		}
		else {
			 msg= "FROM product_detail WHERE p_category=? ";	
		}
		
	}
	int total=0;
	try {
		conn=dbconn.getConnection();
		String sql= "Select CEIL(COUNT(*)/"+ROW_SIZE+") "+ msg; 
		ps=conn.prepareStatement(sql);
		
		if(!(ct.equals("전체"))) {
			ps.setString(1, ct);
		}
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
		
		sql="SELECT pno,p_name,p_lower_price,p_percent,p_category,p_hit,p_image,p_intprice from product_detail where pno="+pno;
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


}
