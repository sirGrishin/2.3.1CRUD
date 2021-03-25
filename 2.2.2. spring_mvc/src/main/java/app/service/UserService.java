package app.service;


import app.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);


    User getUser(long id);

    void deleteUser(long id);
}
