/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * SysType.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�SysType.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-9
 */
public class SysType {

	/**
	 * ����������ϵͳ���
	 */
	private int id;

	/**
	 * ����ϵͳ����
	 */
	private String typeName;

	/**
	 * ����ϵͳ������
	 */
	private String shortName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
