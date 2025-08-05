package app.todo.todoapp.services.impl;

import app.todo.todoapp.models.User;
import app.todo.todoapp.services.UserService;

import java.util.List;

public class UserImpl implements UserService {

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
