/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * SysType.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：SysType.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-9
 */
public class SysType {

	/**
	 * 主键，操作系统编号
	 */
	private int id;

	/**
	 * 操作系统名称
	 */
	private String typeName;

	/**
	 * 操作系统短名称
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
