package ua.univ.services;

import ua.univ.dao.SuccessDAO;
import ua.univ.dao.UserDAO;
import ua.univ.entities.User;

import java.util.ArrayList;
import java.util.List;

public class ShowTableService{

     private static List<String> sortedUsers =new SuccessDAO().sortUsersBySuccess();
     public List<User> getTable(){
         List<User> res = new ArrayList<>();
         UserDAO us = new UserDAO();
         for (int i = 0; i <sortedUsers.size(); i++) {
             User cur = us.getUserWithSuccess(sortedUsers.get(i));
             res.add(cur);
         }
         return res;
     }
}
