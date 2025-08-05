package app.todo.todoapp.services.impl;

import app.todo.todoapp.models.Task;
import app.todo.todoapp.repository.TaskRepository;

import app.todo.todoapp.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServicesImpl implements TaskServices {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServicesImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public String storeTask(Task task) {
        taskRepository.save(task);
        return "Task stored successfully!";
    }

    @Override
    public String updatedTask(Task task) {
        if (!taskRepository.existsById(task.getId())) {
            return "Task not found";
        }
        taskRepository.save(task);
        return "Task updated successfully!";
    }

    @Override
    public String deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            return "Task not found";
        }
        taskRepository.deleteById(id);
        return "Task deleted successfully!";
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
