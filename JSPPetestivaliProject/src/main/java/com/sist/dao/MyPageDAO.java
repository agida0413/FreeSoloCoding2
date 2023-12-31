package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbcp.*;
import com.sist.vo.MyPageVO;

public class MyPageDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPconnection dbconn=new CreateDBCPconnection();
	private static MyPageDAO dao;
	
	public static MyPageDAO newInstance()
	{
		if(dao==null)
			dao=new MyPageDAO();
		return dao;
	}
	
	public void petRegInsert(MyPageVO vo)
	{
		try
		{
			conn=dbconn.getConnection();
			String sql="INSERT INTO pet_reg (petno, pet_image, pet_name, pet_bday, pet_gender, pet_weight, pet_filename,pet_filesize) "
					+ "VALUES (pr_petno_seq.nextval,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getPet_image());
			ps.setString(2, vo.getPet_name());
			ps.setString(3, vo.getPet_bday());
			ps.setString(4, vo.getPet_gender());
			ps.setString(5, vo.getPet_weight());
			ps.setString(6, vo.getPet_filename());
			ps.setInt(7, vo.getPet_filesize());
			
			ps.executeUpdate();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			dbconn.disConnection(conn, ps);
		}
	}
	
//	public List<MyPageVO> petRegData()
//	{
//		List<MyPageVO> list=new ArrayList<MyPageVO>();
//		try
//		{
//			conn=dbconn.getConnection();
//			String sql="SELECT petno, pet_image, pet_name, pet_bday, pet_gender, pet_weight"
//					+ "FROM pet_reg "
//					+ "ORDER BY petno DESC";
//			ps=conn.prepareStatement(sql);
//			ResultSet rs=ps.executeQuery();
//			while(rs.next())
//			{
//				MyPageVO vo=new MyPageVO();
//				vo.setPetno(rs.getInt(1));
//				vo.setPet_image(rs.getString(2));
//				vo.setPet_name(rs.getString(3));
//				vo.setPet_bday(rs.getString(4));
//				vo.setPet_gender(rs.getString(5));
//				vo.setPet_weight(rs.getString(6));
//				list.add(vo);
//			}
//			rs.close();
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		finally
//		{
//			dbconn.disConnection(conn, ps);
//		}
//		return list;
//	}
//	
	public MyPageVO petInfo(int pno)
	{
		MyPageVO vo=new MyPageVO();
		try
		{
			conn=dbconn.getConnection();
			String sql="SELECT petno, pet_filename, pet_name, pet_bday, pet_gender, pet_wegith "
					+ "FROM pet_reg "
					+ "WHERE petno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pno);
			ResultSet rs=ps.executeQuery();
			rs.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			dbconn.disConnection(conn, ps);
		}
		return vo;
	}
	
}
