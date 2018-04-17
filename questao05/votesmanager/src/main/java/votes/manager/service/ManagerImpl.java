/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.manager.service;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import votes.manager.repository.RepositorySingleton;

/**
 *
 * @author juan
 */
@WebService(
        endpointInterface = "votes.manager.service.Manager",
        serviceName = "ManagerService"
)
public class ManagerImpl implements Manager {

    private static List<Integer> idList;
    RepositorySingleton repo;

    public ManagerImpl() {
        idList = new ArrayList<>();
        repo = RepositorySingleton.getInstance();
    }

    @Override
    public void subscribe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vote(String candidate) {
        int voteId = createId();
        String response = repo.store(voteId, candidate);
        if(response.equals("OK"))
            return Integer.toString(voteId);
        return "ERROR";
    }

    public int createId() {
        int voteId = (int) (Math.round(Math.random() * 89999999) + 10000000);
        if (idList.contains(voteId)) {
            return createId();
        } else {
            idList.add(voteId);
            return voteId;
        }
    }
}
