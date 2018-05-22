package ua.univ.services.admin;

import ua.univ.dao.SuccessDAO;
import ua.univ.dao.UserDAO;
import ua.univ.entities.Success;
import ua.univ.entities.User;
import ua.univ.exceptions.DataBaseException;
import ua.univ.factories.DAOFactory;
import ua.univ.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ShowTableService{

    private static final DAOFactory daoFactory=DAOFactory.getInstance();
     public List<User> getTable(){
         try{
             Transaction.beginTransaction();
             List<String> sortedUsers = daoFactory.getSuccessDAO().getSortedUsersBySuccess();
             List<User> users = new ArrayList<>();
             for (int i = 0; i <sortedUsers.size(); i++) {
                 User user=null;
                 user = formUserWithSuccess(sortedUsers.get(i));
                 users.add(user);
             }
             Transaction.endTransaction();
             return users;
         }
         catch (DataBaseException e){ return null; }
     }
     private User formUserWithSuccess(String email)throws DataBaseException{
         User user=null;
         try{
         user= daoFactory.getUserDAO().getUser(email);
         Success success =daoFactory.getSuccessDAO().getSuccess(user);
         user.setSuccess(success);
         Transaction.commit();
         }
         catch (DataBaseException e){
             Transaction.rollback();
             throw e;
         }

         return user;
     }

}
