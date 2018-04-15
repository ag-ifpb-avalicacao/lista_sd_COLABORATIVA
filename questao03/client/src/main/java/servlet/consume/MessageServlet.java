/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.consume;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ws.chat.service.WSChat;
import ws.chat.service.WSChatService;
import ws.message.service.Message;

/**
 *
 * @author juan
 */
public class MessageServlet extends HttpServlet{
    
    WSChatService proxy;
    WSChat chat;
    

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");
        setPolicy(res);

        String verifier = req.getParameter("list");
        if(verifier==null)
            req.getRequestDispatcher("main.jsp").forward(req, res);
        
        proxy = new WSChatService();
        chat = proxy.getWSChatImplPort();

        JSONArray array = new JSONArray();

        List<JSONObject> mapped = chat.listMessages().stream().map((message) -> {
            JSONObject object = new JSONObject();
            object.put("nickname", message.getUserOwner());
            object.put("content", message.getContent());
            return object;
        }).collect(Collectors.toList());

        array.addAll(mapped);

        PrintWriter writer = res.getWriter();
        writer.print(array);
        writer.flush();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setCharacterEncoding("utf-8");
        setPolicy(res);
        
        proxy = new WSChatService();
        chat = proxy.getWSChatImplPort();

        String nickname = req.getParameter("nickname");
        String content = req.getParameter("message");

        Message message = new Message();
        message.setUserOwner(nickname);
        message.setContent(content);
        
        chat.sendMessage(message);
        RequestDispatcher red = req.getRequestDispatcher("main.jsp");
        red.forward(req, res);
    }

    public void setPolicy(HttpServletResponse res) {
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        res.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        res.addHeader("Access-Control-Max-Age", "600");
    }
}
