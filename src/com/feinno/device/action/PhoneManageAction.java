/**
 * 
 */
package com.feinno.device.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import com.feinno.device.bean.PhoneInfo;
import com.feinno.device.bean.PhoneVersion;
import com.feinno.device.bean.VersionInfo;
import com.feinno.device.service.BorrowService;
import com.feinno.device.service.PhoneService;

/**
 * <p>
 * PhoneManageAction.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�PhoneManageAction.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-8
 */
public class PhoneManageAction extends ActionSupport {

	private static final long serialVersionUID = 2886568238700963717L;
	private static Log logger = LogFactory.getLog(PhoneManageAction.class);

	private List<PhoneInfo> phoneList;
	private PhoneService phoneService;
	private BorrowService borrowService;
	private PhoneInfo phoneInfo;
	private String id;
	private String brand;
	private String model;
	private String protocol;
	private String sys_typeid;
	private String sys_version;
	private String isp;
	private String remarks;
	private String parts;
	
	private List<PhoneVersion> phoneVersionList;
	private List<VersionInfo> versionList;
	private String versionNo;

	/**
	 * �г�ȫ�����ֻ���Ϣ
	 * 
	 * @return
	 */
	public String exeGetPhoneList() {
		try {
			phoneList = phoneService.getPhoneList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("ϵͳ�޷���Ӧ��������,���Ժ����ԣ�");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * �����ֻ���ŵõ��ֻ���Ϣ
	 * 
	 * @return
	 */
	public String exeGetPhoneById() {
		try {
			phoneInfo = phoneService.getPhoneById(id);
			phoneVersionList = borrowService.getPhoneVersionList(Integer
					.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("ϵͳ�޷���Ӧ��������,���Ժ����ԣ�");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * �����ֻ�ǰ�ĳ�ʼ��
	 * 
	 * @return
	 */
	public String exeAddPhoneInit() {
		try {
			versionList = phoneService.getVersionList();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("ϵͳ�޷���Ӧ��������,���Ժ����ԣ�");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * �����ֻ���Ϣ
	 * 
	 * @return
	 */
	public String exeAddPhone() {
		try {
			VersionInfo v = phoneService.getVersionByNo(versionNo);
			phoneInfo.setSysTypeId(v.getSysType());
			phoneInfo.setSysVsersion(v.getVersionName());
			phoneService.addPhone(phoneInfo);
			System.out.print("�����ֻ���ϢAAAAAAAAAAA");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("ϵͳ�޷���Ӧ��������,���Ժ����ԣ�");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * �༭�ֻ���Ϣǰ�ĳ�ʼ��
	 * 
	 * @return
	 */
	public String exeModifyPhoneInit() {
		try {
			
			phoneInfo = phoneService.getPhoneById(id + "");
			System.out.print("�༭�ֻ���ϢIIIIIIIIIIIIIIIIIIIIIII");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("ϵͳ�޷���Ӧ��������,���Ժ����ԣ�");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * �޸��ֻ���Ϣ
	 * 
	 * @return
	 */
	public String exeModifyPhone() {
		try {
			phoneService.modifyPhone(phoneInfo);
			phoneInfo.setBrand(brand);
			phoneInfo.setModel(model);
			phoneInfo.setProtocol(protocol);
			phoneInfo.setSysTypeId(sys_typeid);
			phoneInfo.setSysVsersion(sys_version);
			phoneInfo.setIsp(isp);
			phoneInfo.setParts(parts);
			phoneInfo.setRemarks(remarks);
			System.out.print("$�޸��ֻ���ϢMMMMMMMMMMMMMMMMMMMM");
			System.out.print(phoneInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("ϵͳ�޷���Ӧ��������,���Ժ����ԣ�");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * ɾ���ֻ���Ϣ
	 * 
	 * @return
	 */
	public String exeDelPhone() {
		try {
			phoneService.delPhone(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("ϵͳ�޷���Ӧ��������,���Ժ����ԣ�");
			return ERROR;
		}
		return SUCCESS;
	}

	public List<PhoneInfo> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneInfo> phoneList) {
		this.phoneList = phoneList;
	}

	public PhoneService getPhoneService() {
		return phoneService;
	}

	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	public PhoneInfo getPhoneInfo() {
		return phoneInfo;
	}

	public void setPhoneInfo(PhoneInfo phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BorrowService getBorrowService() {
		return borrowService;
	}

	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	public List<PhoneVersion> getPhoneVersionList() {
		return phoneVersionList;
	}

	public void setPhoneVersionList(List<PhoneVersion> phoneVersionList) {
		this.phoneVersionList = phoneVersionList;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSys_typeid() {
		return sys_typeid;
	}

	public void setSys_typeid(String sys_typeid) {
		this.sys_typeid = sys_typeid;
	}

	public String getSys_version() {
		return sys_version;
	}

	public void setSys_version(String sys_version) {
		this.sys_version = sys_version;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getParts() {
		return parts;
	}

	public void setParts(String parts) {
		this.parts = parts;
	}

	public List<VersionInfo> getVersionList() {
		return versionList;
	}

	public void setVersionList(List<VersionInfo> versionList) {
		this.versionList = versionList;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}


	

}
