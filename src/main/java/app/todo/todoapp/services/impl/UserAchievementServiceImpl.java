package app.todo.todoapp.services.impl;

import app.todo.todoapp.models.Achievement;
import app.todo.todoapp.models.User;
import app.todo.todoapp.models.UserAchievement;
import app.todo.todoapp.repository.AchievementRepository;
import app.todo.todoapp.repository.UserAchievementRepository;
import app.todo.todoapp.repository.UserRepository;
import app.todo.todoapp.services.UserAchievementService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserAchievementServiceImpl implements UserAchievementService {

    private final UserRepository userRepository;
    private final AchievementRepository achievementRepository;
    private final UserAchievementRepository userAchievementRepository;

    public UserAchievementServiceImpl(UserRepository userRepository,
                                      AchievementRepository achievementRepository,
                                      UserAchievementRepository userAchievementRepository) {
        this.userRepository = userRepository;
        this.achievementRepository = achievementRepository;
        this.userAchievementRepository = userAchievementRepository;
    }

    @Override
    public UserAchievement assignAchievement(Long userId, Long achievementId) {
        User user = userRepository.findById(userId).orElseThrow();
        Achievement achievement = achievementRepository.findById(achievementId).orElseThrow();

        // Prevent duplicate for non-repeatable
        if (!achievement.isRepeatable() && hasAchievement(userId, achievementId)) {
            throw new IllegalStateException("Achievement already unlocked.");
        }

        UserAchievement userAchievement = new UserAchievement();
        userAchievement.setUser(user);
        userAchievement.setAchievement(achievement);
        userAchievement.setEarnedAt(LocalDateTime.now());

        return userAchievementRepository.save(userAchievement);
    }

    @Override
    public boolean hasAchievement(Long userId, Long achievementId) {
        return userAchievementRepository.existsByUserIdAndAchievementId(userId, achievementId);
    }

    @Override
    public List<UserAchievement> getAchievementsByUser(Long userId) {
        return userAchievementRepository.findByUserId(userId);
    }
}
