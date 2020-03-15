package com.feinno.device.bean;



/**
 * @author zhaoyuzhu
 *
 */
public class SimCardInfo {
	/**
	 * 主键
	 */ 
	private int id;
	/**
	 * 手机号
	 */
	private String phone_no;
	/**
	 * 归属省
	 */ 
	private String province;
	/**
	 * 归属市
	 */
	private String city;	
	/**
	 * 所属site
	 */
	private String site;
	/**
	 * 所属pool
	 */
	private String pool;
	/**
	 * 所属运营商
	 */
	private String card_isp;
	/**
	 * 所属资费品牌
	 */
	private String fee_sign;

	/**
	 * 充值金额
	 */
	private String balance;	
	/**
	 * 充值时间
	 */
	private String rechargeDate;
	
	/**
	 * 是否被借用
	 */
	private int inuse;

	/**
	 * 借用者
	 */
	private String userId;
	
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 是否灰度
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
