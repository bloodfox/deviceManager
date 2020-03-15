package com.feinno.device.bean;



/**
 * @author zhaoyuzhu
 *
 */
public class SimCardInfo {
	/**
	 * ����
	 */ 
	private int id;
	/**
	 * �ֻ���
	 */
	private String phone_no;
	/**
	 * ����ʡ
	 */ 
	private String province;
	/**
	 * ������
	 */
	private String city;	
	/**
	 * ����site
	 */
	private String site;
	/**
	 * ����pool
	 */
	private String pool;
	/**
	 * ������Ӫ��
	 */
	private String card_isp;
	/**
	 * �����ʷ�Ʒ��
	 */
	private String fee_sign;

	/**
	 * ��ֵ���
	 */
	private String balance;	
	/**
	 * ��ֵʱ��
	 */
	private String rechargeDate;
	
	/**
	 * �Ƿ񱻽���
	 */
	private int inuse;

	/**
	 * ������
	 */
	private String userId;
	
	/**
	 * ��ע
	 */
	private String remarks;
	/**
	 * �Ƿ�Ҷ�
	 */
	private String isgray;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPool() {
		return pool;
	}
	public void setPool(String pool) {
		this.pool = pool;
	}
	public String getCard_isp() {
		return card_isp;
	}
	public void setCard_isp(String card_isp) {
		this.card_isp = card_isp;
	}
	public String getFee_sign() {
		return fee_sign;
	}
	public void setFee_sign(String fee_sign) {
		this.fee_sign = fee_sign;
	}

	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getRechargeDate() {
		return rechargeDate;
	}
	public void setRechargeDate(String rechargeDate) {
		this.rechargeDate = rechargeDate;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIsgray() {
		return isgray;
	}
	public void setIsgray(String isgray) {
		this.isgray = isgray;
	}
	
}
