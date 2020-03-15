/**
 * 
 */
package com.feinno.device.service;

import java.util.List;

import com.feinno.device.bean.BorrowInfo;
import com.feinno.device.bean.PhoneVersion;
import com.feinno.device.dao.BorrowDAO;

/**
 * <p>
 * BorrowServiceImpl.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：BorrowServiceImpl.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-10
 */
public class BorrowServiceImpl implements BorrowService {
	BorrowDAO borrowDAO;

	public BorrowDAO getBorrowDAO() {
		return borrowDAO;
	}

	public void setBorrowDAO(BorrowDAO borrowDAO) {
		this.borrowDAO = borrowDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see device.service.BorrowService#borrow(device.bean.BorrowInfo)
	 */
	@Override
	public int borrow(BorrowInfo borrowInfo) throws Exception {
		return borrowDAO.borrow(borrowInfo);
	}

	@Override
	public List<BorrowInfo> selectBorrowList(int status) throws Exception {
		return borrowDAO.selectBorrowList(status);
	}

	@Override
	public int confirmBorrow(int id, int itemId, String borrowItem,
			String endUser) throws Exception {
		return borrowDAO.confirmBorrow(id, itemId, borrowItem, endUser);
	}

	@Override
	public List<BorrowInfo> selectBorrowList(String endUser) throws Exception {
		return borrowDAO.selectBorrowList(endUser);
	}

	@Override
	public int returnBorrow(int id, int itemId,String borrow_item, String endUser, String version)
			throws Exception {
		return borrowDAO.returnBorrow(id, itemId, borrow_item, endUser, version);
	}

	@Override
	public int cancleBorrow(int id, int itemId,String borrowItem, String endUser)
			throws Exception {
		return borrowDAO.cancleBorrow(id, itemId,borrowItem, endUser);
	}

	@Override
	public int confirmReturn(int id, int itemId, String borrowItem,
			String endUser) throws Exception {
		return borrowDAO.confirmReturn(id, itemId, borrowItem, endUser);
	}

	@Override
	public BorrowInfo returnInit(String borrowId) throws Exception {
		return borrowDAO.returnInit(borrowId);
	}
	@Override
	public BorrowInfo returnCardInit(String borrowId) throws Exception {
		return borrowDAO.returnCardInit(borrowId);
	}

	@Override
	public List<PhoneVersion> getPhoneVersionList(int itemId) throws Exception {
		return borrowDAO.getPhoneVersionList(itemId);
	}
	@Override
	public List<BorrowInfo> searchBorrow(int itemId, String borrowType)
			throws Exception {
		return borrowDAO.searchBorrow(itemId, borrowType);
	}

	@Override
	public List<BorrowInfo> searchCardBorrow(int itemId, String borrowType)
			throws Exception {
		return borrowDAO.searchCardBorrow(itemId, borrowType);
	}
}
