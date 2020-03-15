/**
 * 
 */
package com.feinno.device.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.RequestAware;

import com.feinno.device.bean.BorrowInfo;
import com.feinno.device.bean.PhoneInfo;
import com.feinno.device.bean.PhoneVersion;
import com.feinno.device.bean.SimCardInfo;
import com.feinno.device.service.BorrowService;
import com.feinno.device.service.PhoneService;
import com.feinno.device.service.SimCardService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * BorrowManageAction.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：BorrowManageAction.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-10
 */
public class BorrowManageAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 6320683116465931048L;
	private static Log logger = LogFactory.getLog(BorrowManageAction.class);

	private BorrowInfo borrowInfo;
	private BorrowService borrowService;
	private int itemId;
	private String borrowItem;
	private String borrowType;
	private String endUser;
	private String planDate;
	private String remark;
	private List<PhoneInfo> phoneList;
	private PhoneService phoneService;
	private List<BorrowInfo> borrowList;
	private int id;
	private PhoneInfo phoneInfo;
	private String phoneId;
	private String model;
	private String brand;
	private String version;
	private List<PhoneVersion> phoneVersionList;

	private List<SimCardInfo> cardList;
	private SimCardService cardService;
	private SimCardInfo cardInfo;
	private String cardId;
	private String phone_no;
	private String province;
	private String site;
	private String pool;
	private String card_isp;

	/**
	 * 借用手机前的初始化
	 * 
	 * @return
	 */
	public String exeBorrowPhoneInit() {
		try {
			phoneInfo = phoneService.getPhoneById(itemId + "");
			model = phoneInfo.getModel();
			brand = phoneInfo.getBrand();
			phoneId = itemId + "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 借用手机
	 * 
	 * @return
	 */
	public String exeBorrowPhone() {
		try {
			if (borrowInfo == null) {
				borrowInfo = new BorrowInfo();
			}
			borrowInfo.setEndUser(endUser);
			borrowInfo.setItemId(itemId);
			borrowInfo.setPlanDate(planDate);
			borrowInfo.setRemark(remark);
			borrowInfo.setBorrowItem(borrowItem);
			borrowInfo.setBorrowType(borrowType);

			borrowInfo.setRecDate(getDate());
			borrowService.borrow(borrowInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 列出全部的手机信息
	 * 
	 * @return
	 */
	public String exeSelectPhone() {
		try {
			phoneList = phoneService.searchPhone(0);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 选择借用信息
	 * 
	 * @return
	 */
	public String exeSelectBorrow() {
		try {
			borrowList = borrowService.selectBorrowList(0);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 审核借用
	 * 
	 * @return
	 */
	public String confirmBorrow() {
		try {
			int result = borrowService.confirmBorrow(id, itemId, borrowItem,
					endUser);
			// if (result != 1) {
			// return ERROR;
			// }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 审核归还
	 * 
	 * @return
	 */
	public String confirmReturn() {
		try {
			int result = borrowService.confirmReturn(id, itemId, borrowItem,
					endUser);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 选择当前用户的借用信息
	 * 
	 * @return
	 */
	public String exeSelectUserBorrow() {
		try {
			borrowList = borrowService.selectBorrowList(endUser);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 归还借用
	 * 
	 * @return
	 */
	public String returnBorrow() {
		try {
			borrowService.returnBorrow(id, itemId,borrowItem, endUser, version);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 归还手机前的初始化
	 * 
	 * @return
	 */
	public String returnInit() {
		try {
			borrowInfo = borrowService.returnInit(id + "");
			phoneVersionList = borrowService.getPhoneVersionList(itemId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 归还手机卡前的初始化
	 * 
	 * @return
	 */
	public String returnCardInit() {
		try {
			borrowInfo = borrowService.returnCardInit(id + "");
		//	phoneVersionList = borrowService.getPhoneVersionList(itemId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 撤销借用
	 * 
	 * @return
	 */
	public String cancleBorrow() {
		try {
			//borrowService.cancleBorrow(id, itemId,borrowItem, endUser);
			int result = borrowService.cancleBorrow(id, itemId, borrowItem,
					endUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 取得当前日期
	 * 
	 * @return
	 */
	public String getDate() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(now.getTime());
	}

	/**
	 * 列出全部的手机卡信息
	 * 
	 * @return
	 */
	public String exeSelectCard() {
		try {
			cardList = cardService.searchCard(0);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 借用手机卡前的初始化
	 * 
	 * @return
	 */
	public String exeBorrowCardInit() {
		try {
			cardInfo = cardService.getCardById(itemId + "");
			phone_no = cardInfo.getPhone_no();
			card_isp = cardInfo.getCard_isp();
			province = cardInfo.getProvince();
			site = cardInfo.getSite();
			pool = cardInfo.getPool();
			cardId = itemId + "";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 借用手机卡
	 * 
	 * @return
	 */
	public String exeBorrowCard() {
		try {
			
			if (borrowInfo == null) {
				borrowInfo = new BorrowInfo();
			}
			borrowInfo.setEndUser(endUser);
			borrowInfo.setItemId(itemId);
			borrowInfo.setPlanDate(planDate);
			borrowInfo.setRemark(remark);

			borrowInfo.setRecDate(getDate());
			borrowService.borrow(borrowInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询借用手机历史
	 * 
	 * @return
	 */
	public String exeSearchBorrow(){
		try{
			borrowList = borrowService.searchBorrow(itemId, borrowType);
			phoneInfo = phoneService.getPhoneById(itemId+"");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 查询借用手机卡历史
	 * 
	 * @return
	 */
	public String exeSearchCardBorrow(){

		try{
			borrowList = borrowService.searchCardBorrow(itemId, borrowType);
			cardInfo = cardService.getCardById(itemId+"");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	public BorrowInfo getBorrowInfo() {
		return borrowInfo;
	}

	public void setBorrowInfo(BorrowInfo borrowInfo) {
		this.borrowInfo = borrowInfo;
	}

	public BorrowService getBorrowService() {
		return borrowService;
	}

	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getEndUser() {
		return endUser;
	}

	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}

	public String getPlanDate() {
		return planDate;
	}

	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public void setRequest(Map arg0) {

	}

	public List<PhoneInfo> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneInfo> phoneList) {
		this.phoneList = phoneList;
	}

	public PhoneService getPhoneService() {
		return phoneService;
	}

	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	public List<BorrowInfo> getBorrowList() {
		return borrowList;
	}

	public void setBorrowList(List<BorrowInfo> borrowList) {
		this.borrowList = borrowList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhoneInfo getPhoneInfo() {
		return phoneInfo;
	}

	public void setPhoneInfo(PhoneInfo phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

	public String getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<PhoneVersion> getPhoneVersionList() {
		return phoneVersionList;
	}

	public void setPhoneVersionList(List<PhoneVersion> phoneVersionList) {
		this.phoneVersionList = phoneVersionList;
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

	public SimCardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(SimCardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getCard_isp() {
		return card_isp;
	}

	public void setCard_isp(String card_isp) {
		this.card_isp = card_isp;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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

	public String getBorrowItem() {
		return borrowItem;
	}

	public void setBorrowItem(String borrowItem) {
		this.borrowItem = borrowItem;
	}

	public String getBorrowType() {
		return borrowType;
	}

	public void setBorrowType(String borrowType) {
		this.borrowType = borrowType;
	}

}
