/**
 * 
 */
package com.feinno.device.service;

import java.util.List;

import com.feinno.device.bean.PhoneInfo;
import com.feinno.device.bean.VersionInfo;

/**
 * <p>
 * PhoneService.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：PhoneService.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-8
 */
public interface PhoneService {

	/**
	 * 得到全部的手机信息
	 * 
	 * @return
	 * @throws Exception
	 */
	List<PhoneInfo> getPhoneList() throws Exception;

	/**
	 * 增加手机
	 * 
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public int addPhone(PhoneInfo phone) throws Exception;

	/**
	 * 根据编号得到手机信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PhoneInfo getPhoneById(String id) throws Exception;

	/**
	 * 编辑手机信息
	 * 
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public int modifyPhone(PhoneInfo phone) throws Exception;

	/**
	 * 删除手机
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delPhone(String id) throws Exception;

	/**
	 * 搜索手机列表
	 * 
	 * @param inuse
	 * @return
	 * @throws Exception
	 */
	public List<PhoneInfo> searchPhone(int inuse) throws Exception;
	
	/**
	 * 得到全部版本信息
	 * @return
	 * @throws Exception
	 */
	public List<VersionInfo> getVersionList()throws Exception;
	
	/**
	 * 根据编号得到版本信息
	 * @param versionNo
	 * @return
	 * @throws Exception
	 */
	public VersionInfo getVersionByNo(String versionNo)throws Exception;
}
