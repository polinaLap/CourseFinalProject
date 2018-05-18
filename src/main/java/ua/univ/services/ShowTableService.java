package ua.univ.services;

import ua.univ.dao.SuccessDAO;
import ua.univ.dao.UserDAO;
import ua.univ.entities.User;

import java.util.ArrayList;
import java.util.List;

public class ShowTableService{
    private static int countOnPage = 10;
    private static int from=0;
     private static List<String> sortedUsers =new SuccessDAO().sortUsersBySuccess();
     public static List<User> getTable(boolean next){
         if(!next&&from>=countOnPage) from-=countOnPage;
         List<User> res = new ArrayList<>(countOnPage);
         UserDAO us = new UserDAO();
         for (int i = 0; i <countOnPage&&i+from<sortedUsers.size(); i++) {
             User cur = us.getUsersWithSuccess(sortedUsers.get(i+from));
             res.add(cur);
         }
         //from+=countOnPage;
         return res;
     }
}
