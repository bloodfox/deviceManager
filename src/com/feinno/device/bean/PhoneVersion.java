/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * PhoneVersion.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：PhoneVersion.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-9
 */
public class PhoneVersion {

	/**
	 * 主键
	 */
	private int id;

	/**
	 * 手机编号，手机表的主键
	 */
	private int phoneId;

	/**
	 * 手机系统版本编号
	 */
	private String versionId;

	/**
	 * 手机系统版本名称
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
