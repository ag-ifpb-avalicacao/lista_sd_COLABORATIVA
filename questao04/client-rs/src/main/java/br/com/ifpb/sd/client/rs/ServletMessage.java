package br.com.ifpb.sd.client.rs;

import br.com.ifpb.sd.shared.Message;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@WebServlet(name = "MessageServlet", urlPatterns = "/messages")
public class ServletMessage extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setCharacterEncoding("utf-8");
        setPolicy(res);

        String nickname = req.getParameter("nickname");
        String content = req.getParameter("message");

        Message message = new Message();
        message.setUserOwner(nickname);
        message.setContent(content);

        // Enviar para o serviço (insert)
        ClientConfig config = new ClientConfig(JacksonJsonProvider.class);
        Client client = JerseyClientBuilder.createClient(config);
        WebTarget target = client.target("http://message:8080/message-rs/message/insert");
        Invocation.Builder invocation = target.request();
        Response resp = invocation.post(Entity.entity(message, MediaType.APPLICATION_JSON));
        System.out.println("Codigo: " + resp.getStatus());
        RequestDispatcher red = req.getRequestDispatcher("main.jsp");
        red.forward(req, res);
    }

    private void setPolicy(HttpServletResponse res) {
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        res.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        res.addHeader("Access-Control-Max-Age", "600");
    }

}
