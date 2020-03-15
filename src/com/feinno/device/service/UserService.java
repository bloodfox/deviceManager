/**
 * 
 */
package com.feinno.device.service;

import com.feinno.device.bean.UserInfo;

/**
 * <p>
 * UserService.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�UserService.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-26
 */
public interface UserService {

	/**
	 * ��¼
	 * 
	 * @param userId
	 * @param passwd
	 * @return
	 * @throws Exception
	 */
	public int login(String userId, String passwd) throws Exception;

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
}
