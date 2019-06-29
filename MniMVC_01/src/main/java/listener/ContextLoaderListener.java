package listener;

import java.Context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextLoaderListener implements ServletContextListener {


    static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed 호출 ---- 종료");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("contextInitialized 호출 ---- 시작");
        try{

            ServletContext sc = event.getServletContext();
            String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
            applicationContext = new ApplicationContext(propertiesPath);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
