/**
 * 
 */
package com.feinno.device.service;

import java.util.List;

import com.feinno.device.bean.PhoneInfo;
import com.feinno.device.bean.VersionInfo;
import com.feinno.device.dao.PhoneDAO;

/**
 * <p>
 * PhoneServiceImpl.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：PhoneServiceImpl.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-8
 */
public class PhoneServiceImpl implements PhoneService {
	PhoneDAO phoneDAO;

	public PhoneDAO getPhoneDAO() {
		return phoneDAO;
	}

	public void setPhoneDAO(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}

	@Override
	public List<PhoneInfo> getPhoneList() throws Exception {
		return phoneDAO.getPhoneList();
	}

	@Override
	public int addPhone(PhoneInfo phone) throws Exception {
		  //System.out.print("SSSSSSSSSSSSSSSAAAAAAAAAAAAAAAAAAAAAAAAAAAA*");
		return phoneDAO.addPhone(phone);
	}

	@Override
	public int delPhone(String id) throws Exception {
		return phoneDAO.delPhone(id);
	}

	@Override
	public PhoneInfo getPhoneById(String id) throws Exception {
		//System.out.print("111111111");
		return phoneDAO.getPhoneById(id);
	}

	@Override
	public int modifyPhone(PhoneInfo phone) throws Exception {
		//System.out.print("mmmmmmmmmmmmmmmmmmm");
		return phoneDAO.modifyPhone(phone);
	}

	@Override
	public List<PhoneInfo> searchPhone(int inuse) throws Exception {
		return phoneDAO.searchPhone(inuse);
	}

	@Override
	public List<VersionInfo> getVersionList() throws Exception {
		return phoneDAO.getVersionList();
	}

	@Override
	public VersionInfo getVersionByNo(String versionNo) throws Exception {
		return phoneDAO.getVersionByNo(versionNo);
	}

}
