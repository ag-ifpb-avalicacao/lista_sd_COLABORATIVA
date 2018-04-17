/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votes.manager.repository;

import votes.manager.repository.dao.VoteDao;

/**
 *
 * @author juan
 */
public class RepositorySingleton {
    private static RepositorySingleton instance;
    private final VoteDao dao;
    
    private RepositorySingleton() {
        dao = new VoteDao();
    }
    
    public static RepositorySingleton getInstance() {
        if(instance == null)
            return instance = new RepositorySingleton();
        else 
            return instance;
    }
    
    public String store(int voteId, String candidate) {
        boolean b = dao.vote(voteId, candidate);
        if(b)
            return "OK";
        return "ERROR";
    }
}
