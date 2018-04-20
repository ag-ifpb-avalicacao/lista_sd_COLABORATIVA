/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.compute.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import votes.compute.repository.dao.SubscribeDao;
import votes.compute.repository.dao.VotationDao;

/**
 *
 * @author juan
 */
public class RepositorySingleton {

    private static RepositorySingleton instance;
    private final VotationDao votDao;
    private final SubscribeDao subDao;

    private RepositorySingleton() {
        votDao = new VotationDao();
        subDao = new SubscribeDao();
    }

    public static RepositorySingleton getInstance() {
        if (instance == null) {
            instance = new RepositorySingleton();
            return instance;
        } else {
            return instance;
        }
    }
    
    public boolean updateVotation(int value1, int value2) {
        return votDao.updateVotation(value1, value2);
    }
    
    public Map<String, Integer> getVotations() {
        return votDao.getVotation();
    }
    
    public int countRows() {
        return votDao.countRows();
    }
    
    public boolean storeSubscribe(String URL) {
        return subDao.storeSubscribed(URL);
    }

    public List<String> getSubscribeds() {
        return subDao.getSubscribeds();
    }
}
