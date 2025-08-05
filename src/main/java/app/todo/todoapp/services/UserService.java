package app.todo.todoapp.services;

import app.todo.todoapp.models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);
}
