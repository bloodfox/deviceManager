/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * PhoneVersion.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�PhoneVersion.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-9
 */
public class PhoneVersion {

	/**
	 * ����
	 */
	private int id;

	/**
	 * �ֻ���ţ��ֻ��������
	 */
	private int phoneId;

	/**
	 * �ֻ�ϵͳ�汾���
	 */
	private String versionId;

	/**
	 * �ֻ�ϵͳ�汾����
	 */
	private String versionName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

}
