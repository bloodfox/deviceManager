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
 * ϵͳ���ƣ�deviceManage�������ƣ�PhoneService.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-8
 */
public interface PhoneService {

	/**
	 * �õ�ȫ�����ֻ���Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	List<PhoneInfo> getPhoneList() throws Exception;

	/**
	 * �����ֻ�
	 * 
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public int addPhone(PhoneInfo phone) throws Exception;

	/**
	 * ���ݱ�ŵõ��ֻ���Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PhoneInfo getPhoneById(String id) throws Exception;

	/**
	 * �༭�ֻ���Ϣ
	 * 
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public int modifyPhone(PhoneInfo phone) throws Exception;

	/**
	 * ɾ���ֻ�
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delPhone(String id) throws Exception;

	/**
	 * �����ֻ��б�
	 * 
	 * @param inuse
	 * @return
	 * @throws Exception
	 */
	public List<PhoneInfo> searchPhone(int inuse) throws Exception;
	
	/**
	 * �õ�ȫ���汾��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<VersionInfo> getVersionList()throws Exception;
	
	/**
	 * ���ݱ�ŵõ��汾��Ϣ
	 * @param versionNo
	 * @return
	 * @throws Exception
	 */
	public VersionInfo getVersionByNo(String versionNo)throws Exception;
}
