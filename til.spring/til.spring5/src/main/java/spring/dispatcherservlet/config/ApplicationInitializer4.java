/*
package spring.dispatcherservlet.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
    applicationContext.setConfigLocations("/WEB-INF/dispatcher-servlet-context.xml");

    ServletRegistration.Dynamic registration = servletContext.addServlet("rootDispatcher",
        new DispatcherServlet(applicationContext));
    registration.setLoadOnStartup(1);
    registration.addMapping("/");
  }
}
*/