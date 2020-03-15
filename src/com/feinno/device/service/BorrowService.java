/**
 * 
 */
package com.feinno.device.service;

import java.util.List;

import com.feinno.device.bean.BorrowInfo;
import com.feinno.device.bean.PhoneVersion;

/**
 * <p>
 * BorrowService.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：BorrowService.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-10
 */
public interface BorrowService {

	/**
	 * 借用
	 * 
	 * @param borrowInfo
	 * @return
	 * @throws Exception
	 */
	public int borrow(BorrowInfo borrowInfo) throws Exception;

	/**
	 * 选择借用信息列表
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> selectBorrowList(int status) throws Exception;

	/**
	 * 审核借用信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int confirmBorrow(int id, int itemId, String borrowItem,
			String endUser) throws Exception;

	/**
	 * 选择当前用户的借用信息列表
	 * 
	 * @param endUser
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> selectBorrowList(String endUser) throws Exception;

	/**
	 * 归还借用信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int returnBorrow(int id, int itemId, String borrow_item,String endUser, String version)
			throws Exception;

	/**
	 * 撤销借用信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int cancleBorrow(int id, int itemId, String borrowItem,String endUser)
			throws Exception;

	/**
	 * 审核归还信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int confirmReturn(int id, int itemId, String borrowItem,
			String endUser) throws Exception;

	/**
	 * 归还前的初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public BorrowInfo returnInit(String borrowId) throws Exception;
	
	/**
	 * 归还手机卡前的初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public BorrowInfo returnCardInit(String borrowId) throws Exception;

	/**
	 * 得到手机可用的版本号
	 * 
	 * @param itemId
	 * @return
	 * @throws Exception
	 */
	public List<PhoneVersion> getPhoneVersionList(int itemId) throws Exception;
	/**
	 * 根据条件查询手机借用信息
	 * @param itemId
	 * @param borrowType
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> searchBorrow(int itemId,String borrowType)throws Exception;
	/**
	 * 根据条件查询手机卡借用信息
	 * @param itemId
	 * @param borrowType
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> searchCardBorrow(int itemId,String borrowType)throws Exception;
}
