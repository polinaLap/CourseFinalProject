package ua.univ.services;

import ua.univ.dao.TestDAO;
import ua.univ.entities.Test;

public class AddTestService {
    public static boolean add(Test test){
        return new TestDAO().addTest(test);
    }
}
