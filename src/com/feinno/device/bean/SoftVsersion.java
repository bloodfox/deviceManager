/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * SoftVsersion.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�SoftVsersion.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-9
 */
public class SoftVsersion {

	/**
	 * ����
	 */
	private String id;

	/**
	 * �ֻ����
	 */
	private int phoneId;

	/**
	 * �ֻ���װ������汾��
	 */
	private String versionId;

	/**
	 * ��װ����
	 */
	private String installDate;

	/**
	 * ��װ��
	 */
	private String installUser;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getInstallDate() {
		return installDate;
	}

	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}

	public String getInstallUser() {
		return installUser;
	}

	public void setInstallUser(String installUser) {
		this.installUser = installUser;
	}

}
