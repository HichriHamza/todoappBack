package app.todo.todoapp.services.impl;

import app.todo.todoapp.models.Achievement;
import app.todo.todoapp.repository.AchievementRepository;
import app.todo.todoapp.services.AchievementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository repository;

    public AchievementServiceImpl(AchievementRepository repository) {
        this.repository = repository;
    }

    @Override
    public Achievement createAchievement(Achievement achievement) {
        return repository.save(achievement);
    }

    @Override
    public List<Achievement> getAllAchievements() {
        return repository.findAll();
    }

    @Override
    public Optional<Achievement> getById(Long id) {
        return repository.findById(id);
    }
}
