package servlet.tomcat;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import servlet.consume.IndexServlet;
import servlet.consume.MessageServlet;
import servlet.consume.UserServlet;

/**
 *
 * @author rodrigobento
 */
public class Loader {

    public static void main(String[] args) throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        //
        Context ctx = tomcat.addWebapp("/", new File("src/main/webapp/").getAbsolutePath());
        //
        tomcat.addServlet(ctx, "user", new UserServlet());
        tomcat.addServlet(ctx, "messages", new MessageServlet());
        tomcat.addServlet(ctx, "index", new IndexServlet());
        //
        ctx.addServletMapping("/user", "user");
        ctx.addServletMapping("/messages", "messages");
        ctx.addServletMapping("/", "index");
        //
        tomcat.start();
        tomcat.getServer().await();
    }
}
