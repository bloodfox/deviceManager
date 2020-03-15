/**
 * 
 */
package com.feinno.device.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.feinno.device.bean.BorrowInfo;
import com.feinno.device.bean.PhoneVersion;

/**
 * <p>
 * BorrowDAOImpl.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：BorrowDAOImpl.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-13
 */
public class BorrowDAOImpl implements BorrowDAO {
	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	// 回滚时用
	private PlatformTransactionManager transactionManager;

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	/**
	 * 借用
	 * 
	 * @param borrowInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public int borrow(BorrowInfo borrowInfo) throws Exception {
		Object args[] = { borrowInfo.getBorrowType(),
				borrowInfo.getBorrowItem(), borrowInfo.getEndUser(),
			    borrowInfo.getRemark(),	borrowInfo.getPlanDate(), borrowInfo.getItemId() };
		String sql = "insert into borrow_log (borrow_type,borrow_item,str_user,end_user,"
				+ "rec_date,remark,plan_date,item_id) values (?,?,'admin',?,NOW(),?,?,?)";

		String s = "update phones set inuse=1,userid='"
				+ borrowInfo.getEndUser() + "' where id="
				+ borrowInfo.getItemId() + " and inuse=0";
		String ss = "update sim_cards set inuse=1,userid='"
				+ borrowInfo.getEndUser() + "' where id="
				+ borrowInfo.getItemId() + " and inuse=0";
		int r = 0;
		if (borrowInfo.getBorrowItem().equals("phone")) {
			r = jt.update(s);
		} else if (borrowInfo.getBorrowItem().equals("card")) {
			r = jt.update(ss);
		}
		if (r == 1) {
			jt.update(sql, args);
		}

		return r;
	}

	@Override
	/**
	 * 选择借用信息列表
	 * 
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> selectBorrowList(int status) throws Exception {
		final List<BorrowInfo> list = new ArrayList<BorrowInfo>();
		// Object args[] = { status };
		String sql = "select b.id,borrow_type,borrow_item,confirm_status,str_user,end_user,plan_date,rec_date,item_id,model "
				+ "from borrow_log b,phones p where borrow_item='phone' and confirm_status=0 and b.item_id=p.id "
				+ "union "
				+ "select b.id,borrow_type,borrow_item,confirm_status,str_user,end_user,plan_date,rec_date,item_id,s.phone_no as model "
				+ "from borrow_log b,sim_cards s where borrow_item='card' and confirm_status=0 and b.item_id=s.id "
				+ "order by id desc";
		jt.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				BorrowInfo b = new BorrowInfo();
				b.setId(rs.getInt("id"));
				b.setBorrowType(rs.getString("borrow_type"));
				b.setBorrowItem(rs.getString("borrow_item"));
				b.setConfirmStatus(rs.getInt("confirm_status"));
				b.setStrUser(rs.getString("str_user"));
				b.setEndUser(rs.getString("end_user"));
				b.setPlanDate(rs.getString("plan_date"));
				// System.out.println("plan_date" + rs.getString("plan_date"));
				b.setRecDate(rs.getString("rec_date"));
				b.setItemId(rs.getInt("item_id"));
				b.setModel(rs.getString("model"));
				list.add(b);
			}
		});

		return list;
	}

	/**
	 * 审核借用信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public int confirmBorrow(int id, int itemId, String borrowItem,
			String endUser) throws Exception {
		String sql = "update borrow_log set confirm_status=1,confirm_date=NOW() where id='"
				+ id + "'";
		String s = "";
		if (borrowItem.equals("phone")) {
			s = "update phones set inuse=2,userid='" + endUser + "' where id="
					+ itemId;
		} else {
			s = "update sim_cards set inuse=2,userid='" + endUser
					+ "' where id=" + itemId;
		}
		int result = jt.update(sql);
		if (result == 1) {
			jt.update(s);
		}

		return result;
	}

	@Override
	/**
	 * 选择当前用户的借用信息列表
	 * 
	 * @param endUser
	 * @return
	 * @throws Exception
	 */
	public List<BorrowInfo> selectBorrowList(String endUser) throws Exception {
		final List<BorrowInfo> list = new ArrayList<BorrowInfo>();
		String sql = "select b.*,p.model from borrow_log b,phones p where (end_user='"
				+ endUser
				+ "' or str_user='"
				+ endUser
				+ "' ) and fact_date is null and b.item_id=p.id "
				+ "union "
				+ "select b.*,s.phone_no as model from borrow_log b,sim_cards s where (end_user='"
				+ endUser
				+ "' or str_user='"
				+ endUser
				+ "' ) and fact_date is null and b.item_id=s.id order by id desc";
		// String sql =
		// "select * from borrow_log b,phones p ,sim_cards s where borrow_item='phone' and (end_user='"
		// + endUser
		// + "' or str_user='"
		// + endUser
		// +
		// "' ) and fact_date is null and b.item_id=p.id order by b.rec_date desc";
		// if (endUser.equals("admin")) {
		// sql =
		// "select * from borrow_log where borrow_type=1 and borrow_item='phone' and fact_date is null";
		// }
		jt.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				BorrowInfo b = new BorrowInfo();
				b.setId(rs.getInt("id"));
				b.setBorrowType(rs.getString("borrow_type"));
				b.setBorrowItem(rs.getString("borrow_item"));
				b.setConfirmStatus(rs.getInt("confirm_status"));
				b.setStrUser(rs.getString("str_user"));
				b.setEndUser(rs.getString("end_user"));
				b.setPlanDate(rs.getString("plan_date"));
				b.setRecDate(rs.getString("rec_date"));
				b.setItemId(rs.getInt("item_id"));
				b.setModel(rs.getString("model"));
				list.add(b);
			}
		});
		return list;
	}

	@Override
	@Transactional
	/**
	 * 归还借用信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int returnBorrow(int id, int itemId,String borrow_item, String endUser, String version)
			throws Exception {
//		String sql = "insert into borrow_log (borrow_type,borrow_item,str_user,end_user,"
//				+ "rec_date,item_id,last_id) values (2,'phone','"
//				+ endUser
//				+ "','admin',NOW(),'" + itemId + "','" + id + "')";
//		String ss = "update borrow_log set fact_date=NOW() where id=" + id;
//		String s = "update phones set inuse=3,userid='',sys_version='"
//				+ version + "' where id=" + itemId;
//		int result = jt.update(sql);
//		jt.update(ss);
//		jt.update(s);
//		return result;
//	}
	

	String sql = "insert into borrow_log (borrow_type,borrow_item,str_user,end_user,"
			+ "rec_date,item_id,last_id) values (2,'"+borrow_item+"','" 
			+ endUser
			+ "','admin',NOW(),'" + itemId + "','" + id + "')";
			
	String ss = "update borrow_log set fact_date=NOW() where id=" + id;
			
	String s1 = "update phones set inuse=3,sys_version='"
				+ version + "' where id=" + itemId;
	String s2 = "update sim_cards set inuse=3 where id=" + itemId;
	int r = 0;
	if (borrow_item.equals("phone")) {
		int result = jt.update(sql);
		r = jt.update(ss);
		r = jt.update(s1);
	} else if (borrow_item.equals("card")) {
		int result = jt.update(sql);
		r = jt.update(ss);
		r = jt.update(s2);
	}
	return r;
}

	@Override
	/**
	 * 撤销借用信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int cancleBorrow(int id, int itemId,String borrowItem, String endUser)
			throws Exception {
		String sql = "update borrow_log set confirm_status=2,confirm_date=NOW() where id='"
				+ id + "'";
		// String s = "update phones set inuse=0,userid='' where id=" + itemId;
//		String s = "update sim_cards set inuse=0,userid='' where id=" + itemId;
//		int result = jt.update(sql);
//		jt.update(s);
//		return result;
//	}

	String s = "";
	if (borrowItem.equals("phone")) {
		s = "update phones set inuse=0,userid='' where id=" + itemId;
	} else {
		s = "update sim_cards set inuse=0,userid='' where id=" + itemId;
	}
	int result = jt.update(sql);
	if (result == 1) {
		jt.update(s);
	}

	return result;
}
	@Override
	/**
	 * 审核归还信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public int confirmReturn(int id, int itemId, String borrowItem,
			String endUser) throws Exception {
		String sql = "update borrow_log set confirm_status=1,confirm_date=NOW(),fact_date=NOW() where id='"
				+ id + "'";
		String s = "";
		//System.out.println(borrowItem);
		if (borrowItem.equals("phone"))
			s = "update phones set inuse=0,userid='' where id=" + itemId;
		else if (borrowItem.equals("card"))
			s = "update sim_cards set inuse=0,userid='' where id=" + itemId;
		int result = jt.update(sql);
		jt.update(s);
		return result;
	}

	@Override
	/**
	 * 归还手机前的初始化
	 * 
	 * @return
	 * @throws Exception
	 */
	public BorrowInfo returnInit(String borrowId) throws Exception {
		String sql = "select * from borrow_log b,phones p where b.id='"
				+ borrowId + "' and b.item_id=p.id";
		final BorrowInfo b = new BorrowInfo();
		jt.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				b.setId(rs.getInt("id"));
				b.setBorrowType(rs.getString("borrow_type"));
				b.setBorrowItem(rs.getString("borrow_item"));
				b.setConfirmStatus(rs.getInt("confirm_status"));
				b.setStrUser(rs.getString("str_user"));
				b.setEndUser(rs.getString("end_user"));
				b.setPlanDate(rs.getString("plan_date"));
				b.setRecDate(rs.getString("rec_date"));
				b.setItemId(rs.getInt("item_id"));
				b.setModel(rs.getString("model"));
			}
		});
		return b;
	}
	
	@Override
	/**
	 * 归还手机卡前的初始化
	 * 
	 * @return
	 * @throws Exception
	 */	
	public BorrowInfo returnCardInit(String borrowId) throws Exception {
//		String sql = "select p.id,borrow_type,borrow_item,confirm_status,str_user,end_user,plan_date,rec_date,item_id,model from borrow_log b,phones p where b.id='"
//				+ borrowId + "' and b.item_id=p.id"
//				+ "union "
//				+ "select s.id,borrow_type,borrow_item,confirm_status,str_user,end_user,plan_date,rec_date,item_id,s.phone_no as model from borrow_log b,sim_cards s where b.id='"
//				+ borrowId + "' and b.item_id=s.id"	;
		String sql = "select b.id,borrow_type,borrow_item,confirm_status,str_user,end_user,plan_date,rec_date,item_id,s.phone_no as model from borrow_log b,sim_cards s where b.id='"
				+ borrowId + "' and b.item_id=s.id"	;
		final BorrowInfo b = new BorrowInfo();
		jt.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				b.setId(rs.getInt("id"));
				b.setBorrowType(rs.getString("borrow_type"));
				b.setBorrowItem(rs.getString("borrow_item"));
				b.setConfirmStatus(rs.getInt("confirm_status"));
				b.setStrUser(rs.getString("str_user"));
				b.setEndUser(rs.getString("end_user"));
				b.setPlanDate(rs.getString("plan_date"));
				b.setRecDate(rs.getString("rec_date"));
				b.setItemId(rs.getInt("item_id"));
				b.setModel(rs.getString("model"));
			}
		});
		return b;
	}

	
	@Override
	/**
	 * 得到手机可用的版本号
	 * 
	 * @param itemId
	 * @return
	 * @throws Exception
	 */
	public List<PhoneVersion> getPhoneVersionList(int itemId) throws Exception {
		final List<PhoneVersion> list = new ArrayList<PhoneVersion>();
		String sql = "select p.phone_id,p.version_id,a.version_name from phone_versions p,all_versions a where p.phone_id='"
				+ itemId
				+ "' and p.version_id=a.vsersion_no order by p.version_id desc";
		jt.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				PhoneVersion p = new PhoneVersion();
				p.setPhoneId(rs.getInt("phone_id"));
				p.setVersionId(rs.getString("version_id"));
				p.setVersionName(rs.getString("version_name"));
				list.add(p);
			}
		});
		return list;
	}
	
	/**
	 * 根据查询借用手机历史
	 * @param itemId
	 * @param borrowType
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BorrowInfo> searchBorrow(int itemId, String borrowType)
			throws Exception {
		final List<BorrowInfo> list = new ArrayList<BorrowInfo>();
	//	String sql = "select * from borrow_log where item_id="+itemId+" and borrow_type='"+borrowType+"'  order by id desc";
		String sql = "select * from borrow_log b ,phones p where b.item_id=p.id and item_id="+itemId+"   order by b.id desc";
		jt.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				BorrowInfo b = new BorrowInfo();
//				PhoneInfo p = new PhoneInfo();
				b.setId(rs.getInt("b.id"));
				b.setBorrowType(rs.getString("b.borrow_type"));
				b.setBorrowItem(rs.getString("b.borrow_item"));
				b.setConfirmStatus(rs.getInt("b.confirm_status"));
				b.setStrUser(rs.getString("b.str_user"));
				b.setEndUser(rs.getString("b.end_user"));
				b.setPlanDate(rs.getString("b.plan_date"));
				b.setRecDate(rs.getString("b.rec_date"));
				b.setItemId(rs.getInt("b.item_id"));
//				b.setBrand (rs.getString("p.brand"));
				b.setModel (rs.getString("p.model"));
				list.add(b);
				

			}
		});
		return list;
	}
	/**
	 * 根据查询借用手机卡历史
	 * @param itemId
	 * @param borrowType
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BorrowInfo> searchCardBorrow(int itemId, String borrowType)
			throws Exception {
		final List<BorrowInfo> list = new ArrayList<BorrowInfo>();
		String sql = "select b.*,s.phone_no as model from borrow_log b,sim_cards s where b.item_id=s.id and item_id="+itemId+"   order by b.id desc";
		jt.query(sql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				BorrowInfo b = new BorrowInfo();
				b.setId(rs.getInt("b.id"));
				b.setBorrowType(rs.getString("b.borrow_type"));
				b.setBorrowItem(rs.getString("b.borrow_item"));
				b.setConfirmStatus(rs.getInt("b.confirm_status"));
				b.setStrUser(rs.getString("b.str_user"));
				b.setEndUser(rs.getString("b.end_user"));
				b.setPlanDate(rs.getString("b.plan_date"));
				b.setRecDate(rs.getString("b.rec_date"));
				b.setItemId(rs.getInt("b.item_id"));
				b.setModel (rs.getString("s.model"));
//				System.out.print("11111111111111111111");
//				System.out.print(rs.getString("s.model")+"33333333333333333333333333333333" );
				list.add(b);
				

			}
		});
		return list;
	}
}
