package app.todo.todoapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String title;

    private String description;

    private String iconUrl;

    private boolean repeatable = false;

    private int requiredCount = 1;

    @Column(length = 50)
    private String conditionType; // e.g., TASKS_COMPLETED, STREAK_DAYS, REMINDERS_SET
}
