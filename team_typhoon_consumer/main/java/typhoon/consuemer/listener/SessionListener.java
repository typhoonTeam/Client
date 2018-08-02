package typhoon.consuemer.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import typhoon.consuemer.pojo.ApplicationConstants;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *@author dunn 2018-7-14
 */
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener {

	/**
	 * Default constructor. 
	 */
	public SessionListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se)  { 
		HttpSession session = se.getSession();
		// 添加到map
		ApplicationConstants.SESSION_MAP.put(session.getId(), session);
		// 访问总人数++
		ApplicationConstants.TOTAL_HISTORY_COUNT++;
		// 如果map总数大于最高同时在线人数则更新最高在线人数及时间
		if (ApplicationConstants.MAX_ONLINE_COUNT < ApplicationConstants.SESSION_MAP.size()) {
			ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP.size();
			ApplicationConstants.MAX_ONLINE_COUNT_DATE = new Date();
		}
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se)  { 
		// 获取即将被销毁的session
		HttpSession session = se.getSession();
		// 在map中根据key移除
		ApplicationConstants.SESSION_MAP.remove(session.getId());
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se)  { 
		// 判断是否添加的用户登录信息session
		if (se.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
			// 当前登录用户数++
			ApplicationConstants.CURRENT_LOGIN_COUNT++;
			// 是否在其他机器登录处理
			isLoginInOtherPlace(se);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se)  { 
		// 判断是否移除的用户登录信息session
		if (se.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
			// 当前登录用户数--
			ApplicationConstants.CURRENT_LOGIN_COUNT--;
			// 是否在其他机器登录处理
			isLoginInOtherPlace(se);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se)  { 
		// 判断是否修改的用户登录信息session
		if (se.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
			// 是否在其他机器登录处理
			isLoginInOtherPlace(se);
		}
	}
	private void isLoginInOtherPlace(HttpSessionBindingEvent event) {
		// 获取添加的session
		HttpSession session = event.getSession();
		// 遍历查找此用户是否登录
		for (HttpSession s : ApplicationConstants.SESSION_MAP.values()) {
			// 如果已经在其他机器登录则使其失效
			if (event.getValue().equals(s.getAttribute(ApplicationConstants.LOGIN_SESSION_NAME))
					&& session.getId() != s.getId()) {
				// 使session失效
				session.invalidate();
				break;
			}
		}
	}

}
