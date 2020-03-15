/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * PhoneInfo.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�PhoneInfo.java
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
	 * ����
	 */
	private int id;

	/**
	 * �ֻ�����Ʒ��
	 */
	private String brand;

	/**
	 * �ֻ������ͺ�
	 */
	private String model;

	/**
	 * �ֻ���������ϵͳ����
	 */
	private String sysTypeId;

	/**
	 * �ֻ��������Ű汾
	 */
	private String sysVsersion;
	/**
	 * �ֻ�����֧��ȫ�����Ű汾
	 */
	private String sysAllVersion;

	/**
	 * �ֻ�֧�ֵ���Ӫ��
	 */
	private String isp;

	/**
	 * �ֻ�֧�ֵ�Э������
	 */
	private String protocol;

	/**
	 * �Ƿ񱻽���
	 */
	private int inuse;

	/**
	 * ������
	 */
	private String userId;
	/**
	 * ���
	 */
	private String parts;
	/**
	 * ��ע
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
