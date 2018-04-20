/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.consume;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import web.app.repository.SingletonRepository;

/**
 *
 * @author juan
 */
public class VoteListener extends HttpServlet {

    SingletonRepository repo;

    public VoteListener() {
        repo = SingletonRepository.getInstance();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        String candidate1 = req.getParameter("candidate1");
        String candidate2 = req.getParameter("candidate2");
        repo.updateVotation("Killua", Integer.parseInt(candidate1));
        repo.updateVotation("Gon", Integer.parseInt(candidate2));
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");
        setPolicy(res);

        JSONObject object = new JSONObject(repo.getVotations());
        
        PrintWriter writer = res.getWriter();
        writer.print(object);
        writer.flush();
    }

    public void setPolicy(HttpServletResponse res) {
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        res.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        res.addHeader("Access-Control-Max-Age", "600");
    }
}
