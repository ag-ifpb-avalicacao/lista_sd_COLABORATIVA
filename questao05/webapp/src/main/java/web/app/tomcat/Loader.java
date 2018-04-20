/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.tomcat;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import web.app.consume.IndexServlet;
import web.app.consume.SubscribeServlet;
import web.app.consume.VoteListener;

/**
 *
 * @author juan
 */
public class Loader {

    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8080);
            //
            Context ctx = tomcat.addWebapp("/", new File("src/main/webapp/").getAbsolutePath());
            //
            tomcat.addServlet(ctx, "voteListener", new VoteListener());
            tomcat.addServlet(ctx, "subscribe", new SubscribeServlet());
            tomcat.addServlet(ctx, "index", new IndexServlet());
            //
            ctx.addServletMapping("/voteListener", "voteListener");
            ctx.addServletMapping("/", "index");
            ctx.addServletMapping("/subscribe", "subscribe");
            //
            tomcat.start();
            tomcat.getServer().await();
        } catch (ServletException | LifecycleException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
