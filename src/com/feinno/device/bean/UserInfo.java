/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * UserInfo.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�UserInfo.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-9
 */
public class UserInfo {
	/**
	 * ����
	 */
	private int id;

	/**
	 * �û���¼��
	 */
	private String userid;

	/**
	 * �û�����
	 */
	private String userName;

	/**
	 * �û���¼����
	 */
	private String passwd;

	/**
	 * �Ƿ����Ա
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
