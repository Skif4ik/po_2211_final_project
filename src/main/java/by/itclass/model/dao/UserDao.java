package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static by.itclass.constants.DbConstants.*;

public class UserDao {
    private static UserDao dao;

    public UserDao() {
        ConnectionManager.init();
    }

    public static UserDao getInstance(){
        return Objects.isNull(dao) ? new UserDao() : dao;
    }

    public User getUser(String login, String password){
        try(Connection cn = ConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(SELECT_USER)){
            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt(ID_COL);
                String name = rs.getString(NAME_COL);
                String email = rs.getString(EMAIL_COL);
                return new User(id, login, name, email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user, String password) {
        try (Connection cn = ConnectionManager.getConnection();
        PreparedStatement ps = cn.prepareStatement(INSERT_USER)){
            if(isAccessible(user.getLogin(), cn)){
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getName());
                ps.setString(3, user.getEmail());
                ps.setString(4, password);

                return ps.executeUpdate() > 0;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isAccessible(String login, Connection cn){
        try(PreparedStatement ps = cn.prepareStatement(SELECT_USER_BY_LOGIN)){
            ps.setString(1, login);
            return  !ps.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
