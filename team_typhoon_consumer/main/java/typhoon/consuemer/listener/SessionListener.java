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

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se)  { 
		// �ж��Ƿ���ӵ��û���¼��Ϣsession
		if (se.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
			// ��ǰ��¼�û���++
			ApplicationConstants.CURRENT_LOGIN_COUNT++;
			// �Ƿ�������������¼����
			isLoginInOtherPlace(se);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent se)  { 
		// �ж��Ƿ��Ƴ����û���¼��Ϣsession
		if (se.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
			// ��ǰ��¼�û���--
			ApplicationConstants.CURRENT_LOGIN_COUNT--;
			// �Ƿ�������������¼����
			isLoginInOtherPlace(se);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se)  { 
		// �ж��Ƿ��޸ĵ��û���¼��Ϣsession
		if (se.getName().equals(ApplicationConstants.LOGIN_SESSION_NAME)) {
			// �Ƿ�������������¼����
			isLoginInOtherPlace(se);
		}
	}
	private void isLoginInOtherPlace(HttpSessionBindingEvent event) {
		// ��ȡ��ӵ�session
		HttpSession session = event.getSession();
		// �������Ҵ��û��Ƿ��¼
		for (HttpSession s : ApplicationConstants.SESSION_MAP.values()) {
			// ����Ѿ�������������¼��ʹ��ʧЧ
			if (event.getValue().equals(s.getAttribute(ApplicationConstants.LOGIN_SESSION_NAME))
					&& session.getId() != s.getId()) {
				// ʹsessionʧЧ
				session.invalidate();
				break;
			}
		}
	}

}
