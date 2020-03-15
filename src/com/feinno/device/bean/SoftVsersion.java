/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * SoftVsersion.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：SoftVsersion.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-9
 */
public class SoftVsersion {

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 手机编号
	 */
	private int phoneId;

	/**
	 * 手机安装的软件版本号
	 */
	private String versionId;

	/**
	 * 安装日期
	 */
	private String installDate;

	/**
	 * 安装者
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
