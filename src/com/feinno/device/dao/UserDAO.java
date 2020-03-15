/**
 * 
 */
package com.feinno.device.dao;

import com.feinno.device.bean.UserInfo;

/**
 * <p>
 * UserDAO.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�UserDAO.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-26
 */
public interface UserDAO {
	/**
	 * �õ��û���Ϣ
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserInfo getUserInfo(String userId) throws Exception;

	/**
	 * ��������Ա��ɫ
	 * 
	 * @param userId
	 * @param adminId
	 * @return
	 * @throws Exception
	 */
	public int changeUser(String userId, String adminId) throws Exception;

	/**
	 * ��������
	 * 
	 * @param userId
	 * @param pass
	 * @param passNew
	 * @return
	 * @throws Exception
	 */
	public int updatePass(String userId, String pass, String passNew)
			throws Exception;

	/**
	 * �����û�
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int addUser(String userId) throws Exception;
}
