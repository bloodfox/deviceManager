/**
 * 
 */
package com.feinno.device.bean;

/**
 * <p>
 * BorrowInfo.java
 * </p>
 * <p>
 * ϵͳ���ƣ�deviceManage�������ƣ�BorrowInfo.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-1
 */
public class BorrowInfo {

	/**
	 * ����
	 */
	private int id;

	/**
	 * �������ͣ�1Ϊ���ã�2Ϊ�黹
	 */
	private String borrowType;

	/**
	 * ������Ʒ��phoneΪ�ֻ���cardΪ�ֻ���
	 */
	private String borrowItem;

	/**
	 * �ֻ���Ż����ֻ������
	 */
	private int itemId;
	/**
	 * �ֻ��ͺ�
	 */
	private String Model;

	/**
	 * ����������
	 */
	private String strUser;

	/**
	 * �����ս���
	 */
	private String endUser;

	/**
	 * ��¼ʱ��
	 */
	private String recDate;

	/**
	 * ���ȷ��״̬,0Ϊδȷ����ˣ�1Ϊ��ȷ�����
	 */
	private int confirmStatus;

	/**
	 * ȷ��ʱ��
	 */
	private String confirmDate;

	/**
	 * ������;
	 */
	private String remark;

	/**
	 * �ƻ��黹ʱ��
	 */
	private String planDate;

	/**
	 * ʵ�ʹ黹ʱ��
	 */
	private String factDate;

	/**
	 * �������ϴν��ò������
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
