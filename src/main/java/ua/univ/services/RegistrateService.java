package ua.univ.services;

import ua.univ.dao.UserDAO;
import ua.univ.entities.User;

public class RegistrateService {
    public boolean registrate(String name, String email, String password){
        UserDAO ud = new UserDAO();
        if(ud.getUser(email)!=null) return false;
        User u = new User(name,email,password);
        return ud.addUser(u);
    }
}
