package com.feinno.device.service;

import java.util.List;

import com.feinno.device.bean.SimCardInfo;

public interface SimCardService {
	
	/**
	 * �õ�ȫ�����ֻ�����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SimCardInfo> getCardList() throws Exception;

	/**
	 * �����ֻ���
	 * 
	 * @param Card
	 * @return
	 * @throws Exception
	 */
	public int addCard(SimCardInfo card) throws Exception;

	/**
	 * ���ݱ�ŵõ��ֻ�����Ϣ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SimCardInfo getCardById(String id) throws Exception;

	/**
	 * �༭�ֻ�����Ϣ
	 * 
	 * @param card
	 * @return
	 * @throws Exception
	 */
	public int modifyCard(SimCardInfo card) throws Exception;

	/**
	 * ɾ���ֻ���
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delCard(String id) throws Exception;

	/**
	 * �����ֻ����б�
	 * 
	 * @param inuse
	 * @return
	 * @throws Exception
	 */
	public List<SimCardInfo> searchCard(int inuse) throws Exception;

	/**
	 * ��ֵ
	 * 
	 * @param card
	 * @return
	 * @throws Exception
	 */
	public int rechargeCard(SimCardInfo card) throws Exception;

}
