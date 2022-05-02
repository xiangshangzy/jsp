package jsp.listener;
import jsp.bean.Student;
import org.springframework.util.ObjectUtils;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class test implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session=se.getSession();
        String event_name=se.getName();
        String event_id=session.getId();
        Student student=(Student)session.getAttribute("student") ;
       if(!ObjectUtils.isEmpty(student)) {
           System.out.println("session属性增加事件 " + student.getPassword());
       }
       else {
           System.out.println("未创建bean");
       }
    }
}
