package app.todo.todoapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score; // points based on completed tasks

    private int rankPosition; // position in leaderboard

    private String division; // Bronze, Silver, etc.

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}

