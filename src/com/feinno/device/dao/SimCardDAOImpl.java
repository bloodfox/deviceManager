package com.feinno.device.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.feinno.device.bean.SimCardInfo;

public class SimCardDAOImpl implements SimCardDAO {

	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	/**
	 * 得到全部的手机卡信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SimCardInfo> getCardList() throws Exception {
		final List<SimCardInfo> list = new ArrayList<SimCardInfo>();
		String strSql = "select * from sim_cards ";
		jt.query(strSql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				SimCardInfo card = new SimCardInfo();
				card.setId(rs.getInt("id"));
				card.setPhone_no(rs.getString("phone_no"));
				card.setProvince(rs.getString("province"));
				card.setCard_isp(rs.getString("card_isp"));
				card.setCity(rs.getString("city"));
				card.setSite(rs.getString("site"));
				card.setPool(rs.getString("pool"));
				// card.setStr_balance(rs.getString("str_balance"));
				card.setBalance(rs.getString("balance"));
				// card.setEnd_balance(rs.getString("end_balance"));
				card.setFee_sign(rs.getString("fee_sign"));
				card.setInuse(rs.getInt("inuse"));
				card.setUserId(rs.getString("userid"));
				card.setRemarks(rs.getString("remarks"));
				card.setIsgray(rs.getString("isgray"));
				list.add(card);
			}
		});
		return list;
	}

	/**
	 * 增加手机卡
	 * 
	 * @param Card
	 * @return
	 * @throws Exception
	 */
	@Override
	public int addCard(SimCardInfo card) throws Exception {
		Object[] args = { card.getPhone_no(), card.getProvince(),
				card.getCity(), card.getCard_isp(), card.getSite(),
				card.getPool(), card.getBalance(), card.getFee_sign(),
				card.getIsgray(), card.getRemarks() };
		String sql = "insert into sim_cards (phone_no,province,card_isp,city,site,pool,balance,fee_sign,remarks,isgray) values (?,?,?,?,?,?,?,?,?,?)";
		int result = jt.update(sql, args);
		return result;
	}

	/**
	 * 根据编号得到手机卡信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public SimCardInfo getCardById(String id) throws Exception {
		Object[] args = { id };
		final SimCardInfo card = new SimCardInfo();
		String sql = "select * from sim_cards  where id=? ";
		jt.query(sql, args, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				card.setId(rs.getInt("id"));
				card.setPhone_no(rs.getString("phone_no"));
				card.setProvince(rs.getString("province"));
				card.setCard_isp(rs.getString("card_isp"));
				card.setCity(rs.getString("city"));
				card.setSite(rs.getString("site"));
				card.setPool(rs.getString("pool"));
				// card.setStr_balance(rs.getString("str_balance"));
				card.setBalance(rs.getString("balance"));
				// card.setEnd_balance(rs.getString("end_balance"));
				card.setFee_sign(rs.getString("fee_sign"));
				card.setInuse(rs.getInt("inuse"));
				card.setUserId(rs.getString("userid"));
				card.setRemarks(rs.getString("remarks"));
				card.setIsgray(rs.getString("isgray"));
			}
		});

		// System.out.println("sql1"+sql);
		// System.out.println("id"+id);
		return card;
	}

	/**
	 * 编辑手机卡信息
	 * 
	 * @param card
	 * @return
	 * @throws Exception
	 */
	@Override
	public int modifyCard(SimCardInfo card) throws Exception {
		// TODO Auto-generated method stub
		Object[] args = { card.getIsgray(), card.getSite(), card.getPool(),
				card.getId() };
		String sql = "update sim_cards set isgray=?,site=?,pool=? where id=?";
		int result = jt.update(sql, args);
		return result;

	}

	/**
	 * 删除手机卡
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public int delCard(String id) throws Exception {
		Object[] args = { id };
		String sql = "delete from sim_cards where id=?";
		int result = jt.update(sql, args);
		return result;
	}

	/**
	 * 搜索手机卡列表
	 * 
	 * @param inuse
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SimCardInfo> searchCard(int inuse) throws Exception {
		final List<SimCardInfo> list = new ArrayList<SimCardInfo>();
		String strSql = "select * from sim_cards where inuse=" + inuse + "";
		jt.query(strSql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				SimCardInfo card = new SimCardInfo();
				card.setId(rs.getInt("id"));
				card.setPhone_no(rs.getString("phone_no"));
				card.setProvince(rs.getString("province"));
				card.setCard_isp(rs.getString("card_isp"));
				card.setCity(rs.getString("city"));
				card.setSite(rs.getString("site"));
				card.setPool(rs.getString("pool"));
				// card.setStr_balance(rs.getString("str_balance"));
				card.setBalance(rs.getString("balance"));
				// card.setEnd_balance(rs.getString("end_balance"));
				card.setFee_sign(rs.getString("fee_sign"));
				card.setInuse(rs.getInt("inuse"));
				card.setUserId(rs.getString("userid"));
				card.setRemarks(rs.getString("remarks"));
				card.setIsgray(rs.getString("isgray"));
				list.add(card);
			}
		});
		return list;
	}
	/**
	 * 手机卡充值
	 * 
	 * @param inuse
	 * @return
	 * @throws Exception
	 */
	@Override
	public int rechargeCard(SimCardInfo card) throws Exception {
		Object[] args = { card.getPhone_no(), card.getBalance()};
		String sql = "insert into  balance (phone_no ,balance,rechargeDate) values ( ?,?,now()) ";
		String s = "update sim_cards set balance=balance +'"+card.getBalance()+"' where phone_no=" +
				card.getPhone_no();
		int	r = jt.update(s);
		if (r == 1) {
			jt.update(sql, args);
		}
		return r;
		
//		int	result = jt.update(s);
////    	int result = jt.update(sql, args);
//		jt.update(jt.update(sql, args));
//		return result;
	}

}
