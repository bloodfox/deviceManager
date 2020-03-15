/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * PhoneInfo.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：PhoneInfo.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-1
 */
public class PhoneInfo {

	public String getSysAllVersion() {
		return sysAllVersion;
	}

	public void setSysAllVersion(String sysAllVersion) {
		this.sysAllVersion = sysAllVersion;
	}

	/**
	 * 主键
	 */
	private int id;

	/**
	 * 手机所属品牌
	 */
	private String brand;

	/**
	 * 手机所属型号
	 */
	private String model;

	/**
	 * 手机所属操作系统类型
	 */
	private String sysTypeId;

	/**
	 * 手机所属飞信版本
	 */
	private String sysVsersion;
	/**
	 * 手机所属支持全部飞信版本
	 */
	private String sysAllVersion;

	/**
	 * 手机支持的运营商
	 */
	private String isp;

	/**
	 * 手机支持的协议类型
	 */
	private String protocol;

	/**
	 * 是否被借用
	 */
	private int inuse;

	/**
	 * 借用者
	 */
	private String userId;
	/**
	 * 配件
	 */
	private String parts;
	/**
	 * 备注
	 */
	private String remarks;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSysTypeId() {
		return sysTypeId;
	}

	public void setSysTypeId(String sysTypeId) {
		this.sysTypeId = sysTypeId;
	}

	public String getSysVsersion() {
		return sysVsersion;
	}

	public void setSysVsersion(String sysVsersion) {
		this.sysVsersion = sysVsersion;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public int getInuse() {
		return inuse;
	}

	public void setInuse(int inuse) {
		this.inuse = inuse;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getParts() {
		return parts;
	}

	public void setParts(String parts) {
		this.parts = parts;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
