package app.todo.todoapp.services;

import java.util.List;

import app.todo.todoapp.models.Task;

public interface TaskServices {

	String storeTask(Task  task);
	String updatedTask(Task  task);
	String deleteTask(Long id);
	Task   getTaskById(Long id);
	List<Task> getAllTasks();
}
