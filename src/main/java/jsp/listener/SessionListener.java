package jsp.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("创建session,sessionid :" + session.getId());
    }

    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        String event_name = se.getName();
        String event_id = session.getId();
        System.out.println("事件id:" + event_id + " 事件属性名:" + event_name);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("销毁session,sessionid :" + session.getId());
    }
}
