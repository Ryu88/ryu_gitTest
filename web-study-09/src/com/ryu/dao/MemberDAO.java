package com.ryu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ryu.dto.MemberVO;

public class MemberDAO {
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	//사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pwd) {
		int result = -1;
		String sql = "select pass from member where id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass")!=null && rs.getString("pass").equals(pwd)) {
					result=1;
				}else {
					result=0;
				}
			}else {
				result=-1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String userid) {
		MemberVO mVo = null;
		String sql = "select * from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mVo = new MemberVO();
				mVo.setName(rs.getString("NAME"));
				mVo.setUserid(rs.getString("ID"));
				mVo.setPwd(rs.getString("PASS"));
				mVo.setPhone(rs.getString("PHONE"));
				mVo.setAdmin(rs.getInt("AGE"));				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mVo;
	}
	
	//아이디 중복확인
	public int confirmID(String userid) {
		int result = -1;
		String sql = "select id from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;				
			}else {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int insertMember(MemberVO mVo) {
		int result = -1;
		String sql = "insert into member values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserid());
			pstmt.setString(2, mVo.getPwd());
			pstmt.setString(3, mVo.getName());
			pstmt.setString(4, mVo.getPhone());
			pstmt.setInt(5, mVo.getAdmin());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(MemberVO mVo) {
		int result = -1;
		String sql = "update member set pass=?, phone=?, age=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, mVo.getPwd());
			pstmt.setString(2, mVo.getPhone());
			pstmt.setInt(3, mVo.getAdmin());
			pstmt.setString(4, mVo.getUserid());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
