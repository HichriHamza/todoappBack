package app.todo.todoapp.repository;

import app.todo.todoapp.models.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {
    Leaderboard findByUserId(Long userId);
    List<Leaderboard> findByDivision(String division);
}

