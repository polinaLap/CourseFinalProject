package ua.univ.services;

import ua.univ.dao.TestDAO;

import java.util.List;

public class TestListService {
    public List<List<String>> getTests(){
        TestDAO t = new TestDAO();
        return t.getAllTests();
    }
}
