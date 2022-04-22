package com.company.spring_mvc_board.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.company.spring_mvc_board.common.JDBCUtil;

public class UserDAO {
	private Connection 			conn = null;
	private PreparedStatement 	pstmt = null;
	private ResultSet 			rs = null;
	
	private final String USER_GET = "select * from users where id=? and password=?";
	
	public UserDO getUser(UserDO userDO) {
		UserDO user = null;
		
		try {
			System.out.println("===> getUser() 기능 처리됨");
			
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, userDO.getId());
			pstmt.setString(2, userDO.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new UserDO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
			}
			
		} catch (Exception e) {
			System.out.println("===> getUser()" + e);
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}
}
