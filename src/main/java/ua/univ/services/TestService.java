package ua.univ.services;

import ua.univ.dao.TestDAO;
import ua.univ.entities.Test;

public class TestService {
    public Test getTest(String name){
        return  new TestDAO().getTest(name);
    }
}
