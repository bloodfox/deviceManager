/**
 * 
 */
package com.feinno.device.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.SessionAware;

import com.feinno.device.bean.UserInfo;
import com.feinno.device.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>
 * UserManageAction.java
 * </p>
 * <p>
 * 系统名称：deviceManage；类名称：UserManageAction.java
 * </p>
 * 
 * @author zhaoyz
 * @since jdk1.6
 * @version 1.0 2012-6-26
 */
public class UserManageAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8120067717884035430L;
	private static Log logger = LogFactory.getLog(UserManageAction.class);
	private Map session;
	private UserService userService;
	private String userId;
	private String passwd;
	private String passwdnew;
	private String adminId;
	private UserInfo userInfo;

	/**
	 * 登录页面初始化
	 * 
	 * @return
	 */
	public String exeLoginInit() {
		try {
			ActionContext context = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest) context
					.get(StrutsStatics.HTTP_REQUEST);
			HttpServletResponse response = (HttpServletResponse) context
					.get(StrutsStatics.HTTP_RESPONSE);
			Cookie[] cookies = request.getCookies();


			boolean cookieFlag = true;
			if (cookies != null && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					//System.out.println(cookies); 	
					if (cookie.getName().equals("TestUserName")) {						

//						userId = URLDecoder.decode(cookie.getValue(), "UTF-8"); 
						userId = cookie.getValue(); 
					
						int result = 1;
						if (result == 1) {
							UserInfo userInfo = userService.getUserInfo(userId);
							if (userInfo != null
									&& userInfo.getUserid() != null) {
								session.clear();
								session.put("userSession", userInfo);
								return "index";
							}
						}
					} else if (cookie.getName().equals("userId")) {
						userId = cookie.getValue();
						cookieFlag = false;
					}
					// if (cookie.getName().equals("passwd")) {
					// passwd = cookie.getValue();
					// cookieFlag = false;
					// }
				}
			}
			if (cookieFlag) {
				/*
				 * write cookie
				 */
				userId = "";
				// passwd = "";
				Cookie namecookie = new Cookie("userId", userId);
				// Cookie passcookie = new Cookie("passwd", passwd);
				// cookie life
				namecookie.setMaxAge(60 * 60 * 24 * 3650);
				namecookie.setPath("/");
				response.addCookie(namecookie);
				// response.addCookie(passcookie);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 得到用户信息
	 * 
	 * @return
	 */
	public String exelogin() {
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) context
				.get(StrutsStatics.HTTP_RESPONSE);
		// Cookie[] cookies = request.getCookies();
		// boolean cookieFlag = true;
		// if (cookies != null && cookies.length > 0) {
		// for (Cookie cookie : cookies) {
		// if (cookie.getName().equals("userId")) {
		// userId = cookie.getValue();
		// cookieFlag = false;
		// }
		// if (cookie.getName().equals("passwd")) {
		// passwd = cookie.getValue();
		// cookieFlag = false;
		// }
		// }
		// }
		// if (cookieFlag) {
		/*
		 * write cookie
		 */
		Cookie namecookie = new Cookie("userId", userId);
		// Cookie passcookie = new Cookie("passwd", passwd);
		// cookie life
		namecookie.setMaxAge(60 * 60 * 24 * 3650);
		namecookie.setPath("/");
		response.addCookie(namecookie);
		// response.addCookie(passcookie);
		// }
		try {
//			int result = userService.login(userId, passwd);
			 int result = 1;
			if (result == 1) {
				UserInfo userInfo = userService.getUserInfo(userId);
				session.clear();
				session.put("userSession", userInfo);
				return SUCCESS;
			} else if (result == 0) {
				this.addActionMessage("密码错误，请重新输入！");
				return INPUT;
			} else {
				this.addActionMessage("用户名不存在，请重新输入！");
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionMessage("用户名不存在，请重新输入！");
			return INPUT;
		}
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	public String exeLogout() {
		try {
			session.clear();
			session = null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 更换管理员
	 * 
	 * @return
	 */
	public String exeChangeUser() {
		try {
			UserInfo user = (UserInfo) session.get("userSession");
			if (user != null && user.getUserid() != null) {
				if (adminId != null && !adminId.equals("")) {
					adminId = user.getUserid();
					userService.changeUser(userId, adminId);
				}
			}
			session.clear();
			session = null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	public String exeUpdatePassInit() {
		try {
			userInfo = userService.getUserInfo(userId);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 更换密码
	 * 
	 * @return
	 */
	public String exeUpdatePass() {
		try {
			userService.updatePass(userId, passwd, passwdnew);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			this.addActionError("系统无法响应您的请求,请稍后重试！");
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Map getSession() {
		return session;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPasswdnew() {
		return passwdnew;
	}

	public void setPasswdnew(String passwdnew) {
		this.passwdnew = passwdnew;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
