/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.consume;

import br.com.ifpb.sd.shared.User;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClientBuilder;

/**
 *
 * @author rodrigobento
 */
public class UserServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setCharacterEncoding("utf-8");
        setPolicy(res);

        String logout = req.getParameter("logout");
        String nickname = req.getParameter("nickname");
        if (logout != null) {
            if (logout.equals("true")) {
                // Enviar para o serviço rs (logout)
                User u = new User();
                u.setNickname(nickname);
                ClientConfig config = new ClientConfig(JacksonJsonProvider.class);
                Client client = JerseyClientBuilder.createClient(config);
                WebTarget target = client.target("http://localhost:8081/user-rs/user/logout");
                Invocation.Builder invocation = target.request();
                Response response = invocation.post(Entity.entity(u, MediaType.APPLICATION_JSON));
                System.out.println("Codigo: " + response.getStatus());
                res.sendRedirect("index.html");
            }
        }

        String pass = req.getParameter("pass");

        User user = new User();
        user.setNickname(nickname);
        user.setPass(pass);

        // Enviar para o serviço rs (login)
        ClientConfig config = new ClientConfig(JacksonJsonProvider.class);
        Client client = JerseyClientBuilder.createClient(config);
        WebTarget target = client.target("http://localhost:8081/user-rs/user/login");
        Invocation.Builder invocation = target.request();
        Response response = invocation.post(Entity.entity(user, MediaType.APPLICATION_JSON));
        System.out.println("Response: " + response.getStatus());
        RequestDispatcher red = req.getRequestDispatcher("main.jsp");
        HttpSession session = req.getSession();
        session.setAttribute("nickname", nickname);
        red.forward(req, res);
    }

    public void setPolicy(HttpServletResponse res) {
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        res.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        res.addHeader("Access-Control-Max-Age", "600");
    }
}
