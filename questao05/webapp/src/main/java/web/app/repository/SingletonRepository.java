/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.app.repository;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juan
 */
public class SingletonRepository {

    private static SingletonRepository instance;
    private Map<String, Integer> votations;

    private SingletonRepository() {
        votations = new HashMap<>();
        votations.put("Killua", 0);
        votations.put("Gon", 0);
    }

    public static SingletonRepository getInstance() {
        if (instance == null) {
            instance = new SingletonRepository();
            return instance;
        } else {
            return instance;
        }
    }

    public int updateVotation(String candidate, int value) {
        return votations.put(candidate, value);
    }

    public Map<String, Integer> getVotations() {
        return votations;
    }
}
