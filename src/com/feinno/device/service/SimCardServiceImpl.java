package com.feinno.device.service;

import java.util.List;

import com.feinno.device.bean.SimCardInfo;
import com.feinno.device.dao.SimCardDAO;

public class SimCardServiceImpl implements SimCardService {
	
	
	SimCardDAO cardDao;

	public SimCardDAO getCardDao() {
		return cardDao;
	}

	public void setCardDao(SimCardDAO cardDao) {
		this.cardDao = cardDao;
	}

	@Override
	public List<SimCardInfo> getCardList() throws Exception {
		// TODO Auto-generated method stub
		return cardDao.getCardList();
	}

	@Override
	public int addCard(SimCardInfo card) throws Exception {
		// TODO Auto-generated method stub
		return cardDao.addCard(card);
	}

	@Override
	public SimCardInfo getCardById(String id) throws Exception {
		// TODO Auto-generated method stub
	return cardDao.getCardById(id);
	}

	@Override
	public int modifyCard(SimCardInfo card) throws Exception {
		// TODO Auto-generated method stub
		return cardDao.modifyCard(card);
	}

	@Override
	public int delCard(String id) throws Exception {
		// TODO Auto-generated method stub
		return cardDao.delCard(id);
	}

	@Override
	public List<SimCardInfo> searchCard(int inuse) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rechargeCard(SimCardInfo card) throws Exception {
		// TODO Auto-generated method stub
		return cardDao.rechargeCard(card);
	}



}
