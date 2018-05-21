package ua.univ.services.user;

import ua.univ.dao.SuccessDAO;
import ua.univ.entities.User;

import java.util.List;

public class UserSuccessService {
    public boolean getSuccess(User user){
        SuccessDAO s = new SuccessDAO();
        return s.getSuccess(user);
    }
}
