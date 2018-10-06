/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cls;

import DB.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author ZEE
 */
public class listner  implements HttpSessionListener {
    private List<String> sessions = new ArrayList<>();
  
    public static final String COUNTER = "session-counter";

    @Override
    public void sessionCreated(HttpSessionEvent se) {
       System.out.println("SessionCounter.sessionCreated");
        HttpSession session = se.getSession();
     
      
        sessions.add(session.getId());
        session.setAttribute(listner.COUNTER, this);
       
    
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
      System.out.println("SessionCounter.sessionDestroyed");
        HttpSession session = se.getSession();
        getSessions().remove(session.getId());
        session.setAttribute(listner.COUNTER, this);
    }
    
    public int getActiveSessionNumber() {
        return getSessions().size();
    }

    /**
     * @return the sessions
     */
    public List<String> getSessions() {
        return sessions;
    }

    /**
     * @return the users
     */
    
    
}
