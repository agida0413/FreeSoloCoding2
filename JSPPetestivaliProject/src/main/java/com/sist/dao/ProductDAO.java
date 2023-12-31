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
		
		sql="SELECT pno,p_name,p_lower_price,p_percent,p_category,p_hit,p_image,p_intprice,p_price,p_expire_date,p_shipment,p_stack,p_like,p_detail_image,p_intlowerprice from product_detail where pno="+pno;
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
			
			vo.setP_expire_date(rs.getString(10));
			vo.setP_shipment(rs.getString(11));
			vo.setP_stack(rs.getInt(12));
			vo.setP_like(rs.getInt(13));
			vo.setP_detail_image(rs.getString(14));
			vo.setP_intlowerprice(rs.getInt(15));
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

public List<ProductVO> productSubImage(int pno){
	
	List<ProductVO>list= new ArrayList<ProductVO>();
	try {
		conn=dbconn.getConnection();
		String sql="SELECT P_SUB_IMAGE FROM PRODUCT_SUB_IMAGE WHERE pno="+pno;
		ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			ProductVO vo=new ProductVO();
			vo.setP_sub_image(rs.getString(1));
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

public List<ProductVO> productRelativeList(int pno){
	List<ProductVO>list =new ArrayList<ProductVO>();
		try {
			
			conn=dbconn.getConnection();
		
			String sql="SELECT p_category FROM product_detail where pno="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String ct=rs.getString(1);
			rs.close();
			
			
			sql="SELECT pno,p_image,p_name,p_lower_price,num "
						+"FROM(SELECT pno,p_image,p_name,p_lower_price,ROWNUM as num "
						+"FROM (SELECT pno,p_image,p_name,p_lower_price FROM product_detail "
						+"WHERE p_category=? ORDER BY p_hit DESC)) "
						+"WHERE num BETWEEN 1 AND 5";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, ct);
			rs=ps.executeQuery();
			while(rs.next()) {
				ProductVO vo =new ProductVO();
				
				vo.setPno(rs.getInt(1));
				vo.setP_image(rs.getString(2));
				vo.setP_name(rs.getString(3));
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


public List<ProductVO> highSaleList(){
	List<ProductVO> list= new ArrayList<ProductVO>();
	try {
		conn=dbconn.getConnection();
		String sql="SELECT pno,p_image,p_name,p_price,p_lower_price,p_percent,num "
					+"FROM(SELECT pno,p_image,p_name,p_price,p_lower_price,p_percent,ROWNUM as num "
					+"FROM (SELECT pno,p_image,p_name,p_price,p_lower_price,p_percent "
					+"FROM product_detail "
					+"ORDER BY p_intpercent DESC))"
					+"WHERE num BETWEEN 1 AND 9";
		
		ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			ProductVO vo=new ProductVO();
			vo.setPno(rs.getInt(1));
			vo.setP_image(rs.getString(2));
			vo.setP_name(rs.getString(3));
			vo.setP_price(rs.getString(4));
			vo.setP_lower_price(rs.getString(5));
			vo.setP_percent(rs.getString(6));
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


}
