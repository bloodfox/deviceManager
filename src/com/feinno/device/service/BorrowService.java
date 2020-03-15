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
 * ϵͳ���ƣ�deviceManage�������ƣ�BorrowService.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-10
 */
public interface BorrowService {

	/**
	 * ����
	 * 
	 * @param borrowInfo
	 * @return
	 * @throws Exception
	 */
	public int borrow(BorrowInfo borrowInfo) throws Exception;

	/**
	 * ѡ�������Ϣ�б�
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> selectBorrowList(int status) throws Exception;

	/**
	 * ��˽�����Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int confirmBorrow(int id, int itemId, String borrowItem,
			String endUser) throws Exception;

	/**
	 * ѡ��ǰ�û��Ľ�����Ϣ�б�
	 * 
	 * @param endUser
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> selectBorrowList(String endUser) throws Exception;

	/**
	 * �黹������Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int returnBorrow(int id, int itemId, String borrow_item,String endUser, String version)
			throws Exception;

	/**
	 * ����������Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int cancleBorrow(int id, int itemId, String borrowItem,String endUser)
			throws Exception;

	/**
	 * ��˹黹��Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int confirmReturn(int id, int itemId, String borrowItem,
			String endUser) throws Exception;

	/**
	 * �黹ǰ�ĳ�ʼ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public BorrowInfo returnInit(String borrowId) throws Exception;
	
	/**
	 * �黹�ֻ���ǰ�ĳ�ʼ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public BorrowInfo returnCardInit(String borrowId) throws Exception;

	/**
	 * �õ��ֻ����õİ汾��
	 * 
	 * @param itemId
	 * @return
	 * @throws Exception
	 */
	public List<PhoneVersion> getPhoneVersionList(int itemId) throws Exception;
	/**
	 * ����������ѯ�ֻ�������Ϣ
	 * @param itemId
	 * @param borrowType
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> searchBorrow(int itemId,String borrowType)throws Exception;
	/**
	 * ����������ѯ�ֻ���������Ϣ
	 * @param itemId
	 * @param borrowType
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> searchCardBorrow(int itemId,String borrowType)throws Exception;
}
