/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * UserInfo.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：UserInfo.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-9
 */
public class UserInfo {
	/**
	 * 主键
	 */
	private int id;

	/**
	 * 用户登录名
	 */
	private String userid;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 用户登录密码
	 */
	private String passwd;

	/**
	 * 是否管理员
	 */
	private int isAdmin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}
