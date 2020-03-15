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

import com.feinno.device.bean.PhoneInfo;
import com.feinno.device.bean.VersionInfo;

/**
 * <p>
 * PhoneDAOImpl.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：PhoneDAOImpl.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-8
 */
public class PhoneDAOImpl implements PhoneDAO {
	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see device.dao.PhoneDAO#getPhoneList()
	 */
	@Override
	public List<PhoneInfo> getPhoneList() throws Exception {
		final List<PhoneInfo> list = new ArrayList<PhoneInfo>();
		String strSql = "select * from phones";
		jt.query(strSql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				PhoneInfo phone = new PhoneInfo();
				phone.setId(rs.getInt("id"));
				phone.setBrand(rs.getString("brand"));
				phone.setModel(rs.getString("model"));
				phone.setProtocol(rs.getString("protocol"));
				phone.setSysTypeId(rs.getString("sys_typeid"));
				phone.setSysVsersion(rs.getString("sys_version"));
				phone.setSysAllVersion(rs.getString("sys_all_version"));
				phone.setInuse(rs.getInt("inuse"));
				phone.setUserId(rs.getString("userid"));
				phone.setIsp(rs.getString("isp"));
				phone.setParts(rs.getString("parts"));
				phone.setRemarks(rs.getString("remarks"));
           //  System.out.print(rs.getString("sys_all_version"));
           //  System.out.print("11111111111111111111");
				list.add(phone);
			}
		});
		return list;
	}

	@Override
	public int addPhone(PhoneInfo phone) throws Exception {
		Object[] args = { phone.getBrand(), phone.getModel(),
				phone.getSysTypeId(), phone.getSysVsersion(),
                phone.getIsp(),	phone.getProtocol() ,
				phone.getParts(),phone.getRemarks()};

		String sql = "insert into phones (brand,model,sys_typeid,sys_version,isp,protocol,parts,remarks) values (?,?,?,?,?,?,?,?)";
		int result = jt.update(sql, args);
		  System.out.print("ADD*************************************************************************");
		  System.out.print("parts"+phone.getParts());
		  System.out.print("remarks"+phone.getRemarks());
		return result;
	
	}

	@Override
	public int delPhone(String id) throws Exception {
		Object[] args = { id };
		String sql = "delete from phones where id=?";
		int result = jt.update(sql, args);
		return result;
	}

	@Override
	public PhoneInfo getPhoneById(String id) throws Exception {
		Object[] args = { id };
		final PhoneInfo phone = new PhoneInfo();
		String sql = "select * from phones where  id=?"
				;
		jt.query(sql, args, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				phone.setId(rs.getInt("id"));
				phone.setBrand(rs.getString("brand"));
				phone.setModel(rs.getString("model"));
				phone.setProtocol(rs.getString("protocol"));
				phone.setSysTypeId(rs.getString("sys_typeid"));
				phone.setSysVsersion(rs.getString("sys_version"));
			//	phone.setSysAllVersion(rs.getString("sys_all_version"));
				phone.setInuse(rs.getInt("inuse"));
				phone.setUserId(rs.getString("userid"));
				phone.setIsp(rs.getString("isp"));
				phone.setParts(rs.getString("parts"));
				phone.setRemarks(rs.getString("remarks"));
				  System.out.print("BBBBID@@@@@@@@@@@@@@@@@");
			}
		});
		return phone;
	}

	@Override
	public int modifyPhone(PhoneInfo phone) throws Exception {
		Object[] args = { phone.getBrand(), phone.getModel(),
				phone.getSysTypeId(), phone.getSysVsersion(), phone.getIsp(),
				phone.getProtocol(), phone.getParts(),phone.getRemarks(),phone.getId() };
		String sql = "update phones set brand=?,model=?,sys_typeid=?,sys_version=?,isp=?,protocol=?,parts=?,remarks=? where id=?";
		int result = jt.update(sql, args);
		return result;
	}

	@Override
	public List<PhoneInfo> searchPhone(int inuse) throws Exception {
		final List<PhoneInfo> list = new ArrayList<PhoneInfo>();
		String strSql = "select * from phones where inuse=" + inuse + "";
		jt.query(strSql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				PhoneInfo phone = new PhoneInfo();
				phone.setId(rs.getInt("id"));
				phone.setBrand(rs.getString("brand"));
				phone.setModel(rs.getString("model"));
				phone.setProtocol(rs.getString("protocol"));
				phone.setSysTypeId(rs.getString("sys_typeid"));
				phone.setInuse(rs.getInt("inuse"));
				phone.setUserId(rs.getString("userid"));
				phone.setIsp(rs.getString("isp"));
				phone.setParts(rs.getString("parts"));
				phone.setRemarks(rs.getString("remarks"));
				list.add(phone);
			}
		});
		return list;
	}

	@Override
	public List<VersionInfo> getVersionList() throws Exception {
		final List<VersionInfo> list = new ArrayList<VersionInfo>();
		String strSql = "select * from all_versions order by sys_typeid asc ,vsersion_no asc";
		jt.query(strSql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				VersionInfo v = new VersionInfo();
				v.setSysType(rs.getString("sys_typeid"));
				v.setVersionName(rs.getString("version_name"));
				v.setVersionNo(rs.getString("vsersion_no"));
				list.add(v);
			}
		});
		return list;
	}

	@Override
	public VersionInfo getVersionByNo(String versionNo) throws Exception {
		final VersionInfo v = new VersionInfo();
		String strSql = "select * from all_versions where vsersion_no='"+versionNo+"'";
		jt.query(strSql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				v.setSysType(rs.getString("sys_typeid"));
				v.setVersionName(rs.getString("version_name"));
				v.setVersionNo(rs.getString("vsersion_no"));
			}
		});
		return v;
	}
}
