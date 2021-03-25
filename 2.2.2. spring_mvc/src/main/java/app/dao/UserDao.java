package app.dao;


import app.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);
}
