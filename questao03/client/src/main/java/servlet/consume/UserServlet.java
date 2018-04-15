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
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ws.chat.service.WSChat;
import ws.chat.service.WSChatService;
import ws.user.service.User;

/**
 *
 * @author juan
 */
public class UserServlet extends HttpServlet {

    WSChatService proxy;
    WSChat chat;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");
        setPolicy(res);

        String verifier = req.getParameter("list");
        if (verifier == null) {
            req.getRequestDispatcher("main.jsp").forward(req, res);
        }

        proxy = new WSChatService();
        chat = proxy.getWSChatImplPort();

        JSONArray array = new JSONArray();

        List<JSONObject> mapped = chat.listUsers().stream().map((user) -> {
            JSONObject object = new JSONObject();
            object.put("nickname", user.getNickname());
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

        String logout = req.getParameter("logout");
        String nickname = req.getParameter("nickname");
        if (logout != null) {
            if (logout.equals("true")) {
                chat.logout(nickname);
                res.sendRedirect("index.html");
            }
        }

        String pass = req.getParameter("pass");

        User user = new User();
        user.setNickname(nickname);
        user.setPass(pass);

        chat.login(user);
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
