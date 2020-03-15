package com.feinno.device.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.feinno.device.bean.UserInfo;

/**
 * <p>
 * UserDAOImpl.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：UserDAOImpl.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-26
 */
public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	// 回滚时用
	private PlatformTransactionManager transactionManager;

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	@Override
	public UserInfo getUserInfo(String userId) throws Exception {
		Object args[] = { userId };
		final UserInfo userInfo = new UserInfo();
		String sql = "select * from users where userid=?";
		jt.query(sql, args, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				userInfo.setIsAdmin(rs.getInt("isadmin"));
				userInfo.setPasswd(rs.getString("passwd"));
				userInfo.setUserid(rs.getString("userid"));
				userInfo.setUserName(rs.getString("username"));
			}
		});
		return userInfo;
	}

	@Override
	@Transactional
	public int changeUser(String userId, String adminId) throws Exception {
		String sql = "update users set isadmin='1' where userid='" + userId
				+ "'";
		String s = "update users set isadmin='0' where userid='" + adminId
				+ "'";
		// System.out.println(s);
		int result = jt.update(sql);
		result = jt.update(s);
		return result;
	}

	@Override
	public int updatePass(String userId, String pass, String passNew)
			throws Exception {
		Object args[] = { passNew, userId, pass };
		String sql = "update users set passwd=? where userid=? and passwd=?";
		int result = jt.update(sql, args);
		return result;
	}

	@Override
	public int addUser(String userId) throws Exception {
		String sql = "insert into users (userid,username) values('" + userId
				+ "','" + userId + "')";
		int result = jt.update(sql);
		return result;
	}

}
