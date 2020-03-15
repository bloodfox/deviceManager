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
 * 系统名称：deviceManage；类名称：UserService.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-26
 */
public interface UserService {

	/**
	 * 登录
	 * 
	 * @param userId
	 * @param passwd
	 * @return
	 * @throws Exception
	 */
	public int login(String userId, String passwd) throws Exception;

	/**
	 * 得到用户信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserInfo getUserInfo(String userId) throws Exception;

	/**
	 * 更换管理员角色
	 * 
	 * @param userId
	 * @param adminId
	 * @return
	 * @throws Exception
	 */
	public int changeUser(String userId, String adminId) throws Exception;

	/**
	 * 更新密码
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
