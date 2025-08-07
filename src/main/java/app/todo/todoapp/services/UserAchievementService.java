package app.todo.todoapp.services;

import app.todo.todoapp.models.UserAchievement;

import java.util.List;

public interface UserAchievementService {
    UserAchievement assignAchievement(Long userId, Long achievementId);
    boolean hasAchievement(Long userId, Long achievementId);
    List<UserAchievement> getAchievementsByUser(Long userId);
}
