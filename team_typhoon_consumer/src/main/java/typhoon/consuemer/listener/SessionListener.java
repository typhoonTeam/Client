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
public class SessionListener implements  HttpSessionListener {

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
		// ��ӵ�map
		ApplicationConstants.SESSION_MAP.put(session.getId(), session);
		// ����������++
		ApplicationConstants.TOTAL_HISTORY_COUNT++;
		// ���map�����������ͬʱ��������������������������ʱ��
		if (ApplicationConstants.MAX_ONLINE_COUNT < ApplicationConstants.SESSION_MAP.size()) {
			ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP.size();
			ApplicationConstants.MAX_ONLINE_COUNT_DATE = new Date();
		}
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se)  { 
		// ��ȡ���������ٵ�session
		HttpSession session = se.getSession();
		// ��map�и���key�Ƴ�
		ApplicationConstants.SESSION_MAP.remove(session.getId());
	}

}
