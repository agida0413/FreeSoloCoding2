package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.ProductVO;
import com.sist.vo.WalkVO;

public class WalkDAO {
	
private PreparedStatement ps;
private Connection conn;
private static WalkDAO dao;
private CreateDBCPconnection dbconn = new CreateDBCPconnection();
private final int ROW_SIZE=15;


public static WalkDAO newInstance() {
	if(dao==null) {
		dao=new WalkDAO();
	}
	return dao;
	
}

public int walkTotalPage(String loc) {
	String msg="";
	if(!(loc.equals("전체"))){
		
		msg="WHERE signgu_name LIKE '%'||?||'%'";
	}
	
	
	
	
	
	int total=0;
	try {
		conn=dbconn.getConnection();
		String sql= "Select CEIL(COUNT(*)/"+ROW_SIZE+") FROM walk_name_info "+msg;
		ps=conn.prepareStatement(sql);
		if(!(loc.equals("전체"))){
			
			ps.setString(1, loc);
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



public List<WalkVO> walkList(String loc,int page){
	
	List<WalkVO> list= new ArrayList<WalkVO>();
	String msg="";
	
	if(!(loc.equals("전체"))){
		
		msg="WHERE signgu_name LIKE '%'||?||'%'";
	}
	
	
	
	try {
		
		conn= dbconn.getConnection();
		String sql="SELECT wno,w_name,signgu_name,lnm_addr,cours_spot_la,cours_spot_lo,num "
					+"FROM (SELECT wno,w_name,signgu_name,lnm_addr,cours_spot_la,cours_spot_lo,rownum as num "
					+"FROM (SELECT wno,w_name,signgu_name,lnm_addr,cours_spot_la,cours_spot_lo FROM walk_name_info "
					+msg+ ")) "
					+"WHERE num BETWEEN ? AND ?";
		ps=conn.prepareStatement(sql);
		
		int start=(ROW_SIZE*page)-(ROW_SIZE-1);
		int end= ROW_SIZE*page;
		
		if(!(loc.equals("전체"))){
			ps.setString(1, loc);
			ps.setInt(2,start);
			ps.setInt(3, end);
			
		}
		else {
			ps.setInt(1, start);
			ps.setInt(2, end);
		}
		
		
		
	
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			WalkVO vo=new WalkVO();
			vo.setWno(rs.getInt(1));
			vo.setWname(rs.getString(2));
			vo.setSigngu_name(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setcLa(rs.getString(5));
			vo.setcLo(rs.getString(6));
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




public WalkVO walkDetail(int wno) {
	WalkVO vo =new WalkVO();
	try {
		
		conn=dbconn.getConnection();
		String sql="SELECT wno,w_name,signgu_name,lnm_addr,cours_spot_la,cours_spot_lo FROM WALK_NAME_INFO "
					+"WHERE wno="+wno;
			ps=conn.prepareStatement(sql);
		
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setWno(rs.getInt(1));
			vo.setWname(rs.getString(2));
			vo.setSigngu_name(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setcLa(rs.getString(5));
			vo.setcLo(rs.getString(6));
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