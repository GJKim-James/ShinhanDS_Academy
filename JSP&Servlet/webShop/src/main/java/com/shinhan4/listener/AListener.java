package com.shinhan4.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AListener
 *
 */
@WebListener
public class AListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener {
	int total_user;

    public AListener() {
    	System.out.println("AListener 생성자");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	++total_user;
    	System.out.println("sessionCreated 현재 접속자 수 : " + total_user);
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("requestDestroyed");
    }
    
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("requestInitialized");
    }
    
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	--total_user;
    	System.out.println("sessionDestroyed 현재 접속자 수 : " + total_user);
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("contextDestroyed");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("Session attributeAdded");
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("Session attributeReplaced");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("ServletContext contextInitialized");
    }
	
}
