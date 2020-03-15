/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * BorrowInfo.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：BorrowInfo.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-1
 */
public class BorrowInfo {

	/**
	 * 主键
	 */
	private int id;

	/**
	 * 借用类型，1为借用，2为归还
	 */
	private String borrowType;

	/**
	 * 借用物品，phone为手机，card为手机卡
	 */
	private String borrowItem;

	/**
	 * 手机编号或者手机卡编号
	 */
	private int itemId;
	/**
	 * 手机型号
	 */
	private String Model;

	/**
	 * 动作发起者
	 */
	private String strUser;

	/**
	 * 动作终结者
	 */
	private String endUser;

	/**
	 * 记录时间
	 */
	private String recDate;

	/**
	 * 审核确认状态,0为未确认审核，1为已确认审核
	 */
	private int confirmStatus;

	/**
	 * 确认时间
	 */
	private String confirmDate;

	/**
	 * 申请用途
	 */
	private String remark;

	/**
	 * 计划归还时间
	 */
	private String planDate;

	/**
	 * 实际归还时间
	 */
	private String factDate;

	/**
	 * 关联的上次借用操作编号
	 */
	private int lastId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(String borrowType) {
		this.borrowType = borrowType;
	}

	public String getBorrowItem() {
		return borrowItem;
	}

	public void setBorrowItem(String borrowItem) {
		this.borrowItem = borrowItem;
	}

	public String getStrUser() {
		return strUser;
	}

	public void setStrUser(String strUser) {
		this.strUser = strUser;
	}

	public String getEndUser() {
		return endUser;
	}

	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}

	public String getRecDate() {
		return recDate;
	}

	public void setRecDate(String recDate) {
		this.recDate = recDate;
	}

	public int getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(int confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public String getFactDate() {
		return factDate;
	}

	public void setFactDate(String factDate) {
		this.factDate = factDate;
	}

	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}



}
