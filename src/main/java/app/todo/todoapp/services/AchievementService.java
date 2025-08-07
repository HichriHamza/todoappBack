package app.todo.todoapp.services;

import app.todo.todoapp.models.Achievement;

import java.util.List;
import java.util.Optional;

public interface AchievementService {
    Achievement createAchievement(Achievement achievement);
    List<Achievement> getAllAchievements();
    Optional<Achievement> getById(Long id);
}
