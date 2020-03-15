package com.feinno.device.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.feinno.device.bean.SimCardInfo;
import com.feinno.device.service.BorrowService;
import com.feinno.device.service.SimCardService;
import com.opensymphony.xwork2.ActionSupport;

public class SimCardManageAction extends ActionSupport {

	private static final long serialVersionUID = 2886568238700963717L;
	private static Log logger = LogFactory.getLog(SimCardManageAction.class);
	private List<SimCardInfo> cardList;
	private SimCardService cardService;
	private BorrowService borrowService;
	private SimCardInfo cardInfo;
	private String id;
	private String phone_no;
	private String site;
	private String pool;
	private String balance;
	private String isgray;
	private String rechargeDate;

	/**
	 * 获取全部卡信息
	 */
	public String exeGetCardList() {

		try {
			cardList = cardService.getCardList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;

	}

	/**
	 * 通过id获取手机卡信息
	 * 
	 * @return
	 */
	public String exeGetCardById() {
		try {
			cardInfo = cardService.getCardById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;

	}

	/**
	 * 初始化增加卡信息
	 * 
	 * @return
	 */
	public String exeAddCardInit() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 增加手机卡信息
	 * 
	 * @return
	 */
	public String exeAddCard() {
		try {
			cardService.addCard(cardInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 编辑卡信息初始化
	 * 
	 * @return
	 */
	public String exeModifyCardInit() {
		try {
			cardInfo = cardService.getCardById(id + "");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 编辑卡信息
	 * 
	 * @return
	 */
	public String exeModifyCard() {
		try {
			cardService.modifyCard(cardInfo);
			cardInfo.setPool(pool);
			cardInfo.setIsgray(isgray);
			cardInfo.setSite(site);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 充值初始化
	 * 
	 * @return
	 */
	public String exeRechargeCardInit() {
		try {
			cardInfo = cardService.getCardById(id + "");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 充值
	 * 
	 * @return
	 */
	public String exeRechargeCard() {
		try {
			cardService.rechargeCard(cardInfo);
			cardInfo.setBalance(balance);
			cardInfo.setPhone_no(phone_no);
			cardInfo.setRechargeDate(rechargeDate);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	public static Log getLogger() {
		return logger;
	}

	public static void setLogger(Log logger) {
		SimCardManageAction.logger = logger;
	}

	public List<SimCardInfo> getCardList() {
		return cardList;
	}

	public void setCardList(List<SimCardInfo> cardList) {
		this.cardList = cardList;
	}

	public SimCardService getCardService() {
		return cardService;
	}

	public void setCardService(SimCardService cardService) {
		this.cardService = cardService;
	}

	public BorrowService getBorrowService() {
		return borrowService;
	}

	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	public SimCardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(SimCardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
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

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getIsgray() {
		return isgray;
	}

	public void setIsgray(String isgray) {
		this.isgray = isgray;
	}

}
