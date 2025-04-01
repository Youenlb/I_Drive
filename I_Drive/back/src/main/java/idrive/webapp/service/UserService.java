package idrive.webapp.service;

import idrive.webapp.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user) throws Exception;

    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long is, User user);

    String deleteUser(Long id);

    User login(String username, String password) throws Exception;
}
