package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbcp.*;
import com.sist.vo.HospitalVO;

public class HospitalDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPconnection dbconn=new CreateDBCPconnection();
	private static HospitalDAO dao;
	private int row_size=12;
	
	public static HospitalDAO newInstance()
	{
		if(dao==null)
			dao=new HospitalDAO();
		return dao;
	}
	// 병원 전체 리스트 출력
	public List<HospitalVO> HsptFindList(int page,String fd,String st)
	{
		List<HospitalVO> list=new ArrayList<HospitalVO>();
		try
		{
			conn=dbconn.getConnection();
			String sql="SELECT no,hospital_name,hospital_address,hospital_phone,num "
					+ "FROM(SELECT no,hospital_name,hospital_address,hospital_phone,ROWNUM AS num "
					+ "FROM(SELECT no,hospital_name,hospital_address,hospital_phone "
					+ "FROM hospital_search "
					+ "WHERE "+fd+ " LIKE '%'||?||'%' "
					+ "ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			int start=(page*row_size)-(row_size-1);
			int end=(page*row_size);
			ps=conn.prepareStatement(sql);
			ps.setString(1, st);
			ps.setInt(2, start);
			ps.setInt(3, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				HospitalVO vo=new HospitalVO();
				vo.setNo(rs.getInt(1));
				vo.setHospital_name(rs.getString(2));
				vo.setHospital_address(rs.getString(3));
				vo.setHospital_phone(rs.getString(4));
				list.add(vo);
			}
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
		
		return list;
	}
	// 병원 전체 페이지 
	public int totalPage(int no,String fd, String ss)
	{
		int total=0;
		try
		{
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/"+row_size+") "
					+"FROM hospital_search "
					+ "WHERE "+fd+" LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, ss);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
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
		return total;
	}
	// 병원 시도 검색
	public List<HospitalVO> HsptSearchData()
	{
		List<HospitalVO> list=new ArrayList<HospitalVO>();
		try
		{
			conn=dbconn.getConnection();
			String sql="SELECT DISTINCT state "
					+ "FROM hospital_search";
			 ps=conn.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			   
			   while(rs.next())
			   {
				   HospitalVO vo=new HospitalVO();
				   vo.setState(rs.getString(1));
				   list.add(vo);
			   }
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
		return list;
	}
	// 병원찾기상세페이지 출력
	public HospitalVO hsptDetailList(int no)
	{
		HospitalVO vo=new HospitalVO();
		try
		{
			conn=dbconn.getConnection();
			String sql="SELECT no,hospital_name,hospital_address,hospital_phone FROM hospital_search "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setHospital_name(rs.getString(2));
			vo.setHospital_address(rs.getString(3));
			vo.setHospital_phone(rs.getString(4));
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
	
	// 뉴스 전체 데이터
	public List<HospitalVO> hsptNewsList(int page)
	{
		List<HospitalVO> list=new ArrayList<HospitalVO>();
		try
		{
			conn=dbconn.getConnection();
			String sql="SELECT no,news_subject,news_img,num "
					+ "FROM(SELECT no,news_subject,news_img,ROWNUM AS num "
					+ "FROM(SELECT no,news_subject,news_img "
					+ "FROM pet_news "
					+ "ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			int start=(page*row_size)-(row_size-1);
			int end=(page*row_size);
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				HospitalVO vo=new HospitalVO();
				vo.setNo2(rs.getInt(1));
				vo.setNews_subject(rs.getString(2));
				vo.setNews_img(rs.getString(3));
				list.add(vo);
			}
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
		
		return list;
	}
}
