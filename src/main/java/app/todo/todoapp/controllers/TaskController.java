package app.todo.todoapp.controllers;

import app.todo.todoapp.models.Task;
import app.todo.todoapp.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskServices taskServices;

    // Create Task (POST /tasks)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        String result = taskServices.storeTask(task);
        return ResponseEntity.ok(result);
    }

    // Update Task (PUT /tasks)
    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateTask(@RequestBody Task task) {
        String result = taskServices.updatedTask(task);
        return ResponseEntity.ok(result);
    }

    // Delete Task (DELETE /tasks/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        String result = taskServices.deleteTask(id);
        return ResponseEntity.ok(result);
    }

    // Get Task by Id (GET /tasks/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskServices.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    // Get all tasks (GET /tasks)
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskServices.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
}
