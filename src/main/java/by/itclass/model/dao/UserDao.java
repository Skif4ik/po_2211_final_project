package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.util.Objects;

public class UserDao {
    private static UserDao dao;

    public UserDao() {
        ConnectionManager.init();
    }

    public static UserDao getInstance(){
        return Objects.isNull(dao) ? new UserDao() : dao;
    }

    public User getUser(String login, String password){
        return null;
    }

    public boolean addUser(User user, String password) {
        return true;
    }
}
