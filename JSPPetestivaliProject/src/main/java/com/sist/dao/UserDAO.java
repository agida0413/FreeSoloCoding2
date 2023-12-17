package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.dbcp.CreateDBCPconnection;
import com.sist.vo.UserVO;

public class UserDAO {
	private PreparedStatement ps;
	private Connection conn;
	private  static UserDAO dao;
	private CreateDBCPconnection dbconn = new CreateDBCPconnection();
	
	public static UserDAO newInstance() {
		if (dao==null) {
			dao=new UserDAO();
		}
		return dao;
		
	}
	
	public boolean userJoinCheck(String id) {
		int count=0;
		boolean joinCheck=false;
		try {
			
			conn=dbconn.getConnection();
			String sql="SELECT COUNT(*) FROM kyjuser WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);

			if (count==0) {
				joinCheck=true;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		finally {
			dbconn.disConnection(conn, ps);
		}
	return joinCheck;
	}
	
	
	public void userJoin(UserVO vo) {
		
		try {
			conn=dbconn.getConnection();
			String sql="INSERT INTO kyjuser(uno,id,pwd,name) "
						+"VALUES(uno_seq.nextval,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getName());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			dbconn.disConnection(conn, ps);
		}
	}
	
	
	public UserVO userLogin(String id,String pwd) {
		UserVO vo =new UserVO();
		int count=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT COUNT(*) FROM kyjuser WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs= ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
			
			if (count==0) {
				//아이디가 없는경우
				vo.setMsg("NOID");
			}
			else {
				//아이디가 있는경우
				String db_pwd="";
				sql="SELECT pwd FROM kyjuser WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				 rs=ps.executeQuery();
				 rs.next();
				 db_pwd=rs.getString(1);
				 rs.close();
				 
			if (pwd.equals(db_pwd)) {
				//비밀번호 일치
				vo.setMsg("YES");
				sql="SELECT name,admin FROM kyjuser WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs =ps.executeQuery();
				rs.next();
				vo.setName(rs.getString(1));
				vo.setAdmin(rs.getString(2));
				
			}
			else {
				
				//비밀번호 불일치
				vo.setMsg("NOPWD");
				
			}
				
			
			}
			
			
			
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
