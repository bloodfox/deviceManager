package com.feinno.device.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.feinno.device.bean.UserInfo;
import com.feinno.device.dao.UserDAO;

/**
 * <p>
 * UserServiceImpl.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：UserServiceImpl.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-26
 */
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public int login(String userId, String passwd) throws Exception {
		// UserInfo userInfo = userDAO.getUserInfo(userId);
		// if (userInfo.getPasswd() != null && !userInfo.getPasswd().equals(""))
		// {
		// if (userInfo.getPasswd().equals(passwd)) {
		// return 1;
		// } else {
		// return 0;
		// }
		// }
		try {
			// String message = "内容";
			URL url = new URL(
					"http://10.10.208.129/WebSite/Service/CheckPasswordService.asmx/CheckUser?name="
							+ userId + "&passd=" + passwd);
			InputStreamReader isr = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(isr);

			String str = "";
			while ((br.readLine()) != null) {
				str = str.trim() + br.readLine();
			}
			// System.out.println(str);
			str = new String(str.getBytes("gbk"), "utf-8");
			// System.out.println(str);
			// String sss =
			// "<string xmlns=\"http://tempuri.org/\">登陆成功</string>";
			if (str.indexOf("成功") != -1) {
				UserInfo userInfo = userDAO.getUserInfo(userId);
				if (userInfo.getUserid() == null) {
					userDAO.addUser(userId);
				}
				return 1;
			} else if (str.indexOf("失败") != -1) {
				return 0;
			} else if (str.indexOf("不存在") != -1) {
				return -1;
			}
			// message = str.substring(start, end) + "。";
			// System.out.println(message);
			br.close();
			isr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public UserInfo getUserInfo(String userId) throws Exception {
		return userDAO.getUserInfo(userId);
	}

	@Override
	public int changeUser(String userId, String adminId) throws Exception {
		return userDAO.changeUser(userId, adminId);
	}

	@Override
	public int updatePass(String userId, String pass, String passNew)
			throws Exception {
		return userDAO.updatePass(userId, pass, passNew);
	}

}
