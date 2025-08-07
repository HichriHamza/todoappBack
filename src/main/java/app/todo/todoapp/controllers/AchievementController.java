package app.todo.todoapp.controllers;

import app.todo.todoapp.models.Achievement;
import app.todo.todoapp.models.User;
import app.todo.todoapp.models.UserAchievement;
import app.todo.todoapp.repository.UserRepository;
import app.todo.todoapp.services.AchievementService;
import app.todo.todoapp.services.UserAchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {

    private final AchievementService achievementService;
    private final UserAchievementService userAchievementService;
    private final UserRepository userRepository;

    public AchievementController(AchievementService achievementService,
                                 UserAchievementService userAchievementService,
                                 UserRepository userRepository) {
        this.achievementService = achievementService;
        this.userAchievementService = userAchievementService;
        this.userRepository = userRepository;
    }

    // Get all defined achievements
    @GetMapping
    public ResponseEntity<List<Achievement>> allAchievements() {
        return ResponseEntity.ok(achievementService.getAllAchievements());
    }

    // Add a new achievement (admin panel, or pre-setup)
    @PostMapping
    public ResponseEntity<Achievement> createAchievement(@RequestBody Achievement achievement) {
        return ResponseEntity.ok(achievementService.createAchievement(achievement));
    }

    // View logged-in user's unlocked achievements
    @GetMapping("/me")
    public ResponseEntity<List<UserAchievement>> myAchievements(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok(userAchievementService.getAchievementsByUser(user.getId()));
    }

    // Manually assign an achievement (for testing or admin feature)
    @PostMapping("/assign/{achievementId}")
    public ResponseEntity<UserAchievement> assignToMe(@PathVariable Long achievementId, Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok(userAchievementService.assignAchievement(user.getId(), achievementId));
    }
}
