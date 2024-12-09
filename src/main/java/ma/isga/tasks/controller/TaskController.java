package ma.isga.tasks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.isga.tasks.model.Task;
import ma.isga.tasks.repository.TaskRepository;

@RestController
public class TaskController 
{
	@Autowired
	private TaskRepository  taskRepository;
	
	@PostMapping("/tache")
	Task newTask(@RequestBody Task task)
	{
		return taskRepository.save(task);
	}
	
	@GetMapping("/taches")
	List<Task> taches()
	{
		return taskRepository.findAll();
	}
	
	@GetMapping("/tache/{id}")
	Task tacheId(@PathVariable Long id)
	{
		Optional<Task> task= taskRepository.findById(id);
		return task.orElse(null);
		
	}
	
	@DeleteMapping("/tache/{id}")
	String deleteTache(@PathVariable Long id)
	{
		if(taskRepository.existsById(id))
		{
			taskRepository.deleteById(id);
			return "ok";
		}
		return "ko";
	}
	
	
	
	
}
