package ua.univ.services.admin;

import ua.univ.dao.TestDAO;
import ua.univ.entities.Test;

public class AddTestService {
    public boolean add(Test test){
        return new TestDAO().addTest(test);
    }
}
