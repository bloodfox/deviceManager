package com.feinno.device.service;

import java.util.List;

import com.feinno.device.bean.SimCardInfo;

public interface SimCardService {
	
	/**
	 * 得到全部的手机卡信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SimCardInfo> getCardList() throws Exception;

	/**
	 * 增加手机卡
	 * 
	 * @param Card
	 * @return
	 * @throws Exception
	 */
	public int addCard(SimCardInfo card) throws Exception;

	/**
	 * 根据编号得到手机卡信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SimCardInfo getCardById(String id) throws Exception;

	/**
	 * 编辑手机卡信息
	 * 
	 * @param card
	 * @return
	 * @throws Exception
	 */
	public int modifyCard(SimCardInfo card) throws Exception;

	/**
	 * 删除手机卡
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delCard(String id) throws Exception;

	/**
	 * 搜索手机卡列表
	 * 
	 * @param inuse
	 * @return
	 * @throws Exception
	 */
	public List<SimCardInfo> searchCard(int inuse) throws Exception;

	/**
	 * 充值
	 * 
	 * @param card
	 * @return
	 * @throws Exception
	 */
	public int rechargeCard(SimCardInfo card) throws Exception;

}
